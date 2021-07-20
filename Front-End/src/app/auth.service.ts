
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer } from './customer';
import { Employee } from './employee';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loginForm: FormGroup;
  private loggedIn: BehaviorSubject<boolean> = new 
  BehaviorSubject<boolean>(false);
  private apiServerUrl = environment.apiBaseUrl;
  customers: any;
  employees: any;
  private empLoggedIn: BehaviorSubject<boolean> = new 
  BehaviorSubject<boolean>(false);

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  get isEmpLoggedIn() {
    return this.empLoggedIn.asObservable();
  }

  constructor(private router: Router, private http: HttpClient) { 
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
  }

  public login(customer: Customer): Observable<Customer> {
    let cust = this.http.post<Customer>(`${this.apiServerUrl}/customers/login`, customer).subscribe(response => {
      console.log(response);      
      let res = JSON.stringify(response);
      localStorage.setItem('currentUser', res);
      this.loggedIn.next(true);
      if(response != null){
        this.router.navigate(['pets']);
        console.log("test");
        return this.customers;
      }
      // else{
      //   this.loginEmp(customer.username, customer.password);
        
      // }
    });
    
    return null;
  }

  public loginEmp(employee: Employee): Observable<Employee> {
    let emp = this.http.post<Employee>(`${this.apiServerUrl}/employees/login`, employee).subscribe(response => {
      console.log(response);  
      let res = JSON.stringify(response);
      localStorage.setItem('currentUser', res);
      this.empLoggedIn.next(true);
      if(response != null){
        this.router.navigate(['pets']);
        return this.employees;
      }
    
    });
    
    return null;
    
    
  }
  
  logout() {
    this.loggedIn.next(false);
    localStorage.removeItem('currentUser');
    this.router.navigate(['customers/login']);
    console.log("Logout successful");
  }

}
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer } from './customer';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn: BehaviorSubject<boolean> = new 
  BehaviorSubject<boolean>(false);
  private apiServerUrl = environment.apiBaseUrl;
  customers: any;

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  constructor(private router: Router, private http: HttpClient) { }

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
      //   this.loginEmp(this.loginForm.value);
        
      // }
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

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AuthService } from '../auth.service';
import { Customer } from '../customer';
import { Employee } from '../employee';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  private apiServerUrl = environment.apiBaseUrl;
  customers: any;
  employees: any;
  loginStatus$: Observable<boolean>;
  
  constructor(private http: HttpClient, private router: Router, 
    private authService: AuthService) {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
  }

  onSubmit() {
    console.log(this.loginForm.value);
    this.login(this.loginForm.value);
  }

  ngOnInit() {
    this.getCustomers();
    this.loginStatus$ = this.authService.isLoggedIn;
  }

  getCustomers() {
    return this.http.get(`${this.apiServerUrl}/customers`).subscribe(response => {
      console.log(response);
      this.customers = response;
    }, error => {
      console.log(error);
    });
  }

  public login(customer: Customer): Observable<Customer> {
    this.authService.login(customer);
    // let cust = this.http.post<Customer>(`${this.apiServerUrl}/customers/login`, customer).subscribe(response => {
    //   console.log(response);      
    //   let res = JSON.stringify(response);
    //   localStorage.setItem('currentUser', res);
    //   this.loggedIn.next(true);
    //   //window.location.reload();
    //   if(response != null){
    //     this.router.navigate(['pets']);
    //     console.log("test");
    //     return this.customers;
    //   }
    //   else{
    //     this.loginEmp(this.loginForm.value);
        
    //   }
    // });
    
    return null;
  }

  public loginEmp(employee: Employee): Observable<Employee> {
    let emp = this.http.post<Employee>(`${this.apiServerUrl}/employees/login`, employee).subscribe(response => {
      console.log(response);      
      let res = JSON.stringify(response);
      localStorage.setItem('currentUser', res);
     // window.location.reload();
     if(response != null){
      
      this.router.navigate(['pets']);
      return this.employees;
    }
    
    });
    
    return null;
    
    
  }
}


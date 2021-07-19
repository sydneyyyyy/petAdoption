import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer } from '../customer';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  private apiServerUrl = environment.apiBaseUrl;
  customers: any;
  
  constructor(private http: HttpClient, private router: Router) {
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
    let cust = this.http.post<Customer>(`${this.apiServerUrl}/customers/login`, customer).subscribe(response => {
      console.log(response);
      let res = JSON.stringify(response);
      localStorage.setItem('currentUser', res);
      window.location.reload();
    });
    this.router.navigate(['pets']);
    return this.customers;
  }

}


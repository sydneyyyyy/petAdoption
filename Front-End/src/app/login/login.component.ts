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
  private apiServerUrl = "http://localhost:8080";
  customers: any;
  
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
    localStorage.setItem('isEmployee', 'false');
    this.authService.login(customer);
    return null;
  }

  

  
}


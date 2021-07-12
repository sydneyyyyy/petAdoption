import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer } from '../customer';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  private apiServerUrl = environment.apiBaseUrl;
  customers: Customer;
  
  constructor(private http: HttpClient) {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
  }

  onSubmit() {
    console.log(this.loginForm.value);
    this.login(this.loginForm.value);
  }

  public login(customer: Customer): Observable<Customer> {
    console.log(customer.username);
    localStorage.setItem('currentUser', customer.username);
    return this.http.get<Customer>(`${this.apiServerUrl}/login`);
  }
}

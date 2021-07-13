import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer } from '../customer';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  private apiServerUrl = environment.apiBaseUrl;
  customer: any;

  constructor(private http: HttpClient) { 
    this.registerForm = new FormGroup({
      fname: new FormControl('', [Validators.required]),
      lname: new FormControl('', [Validators.required]),
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
    });
  }

  onSubmit() {
    console.log(this.registerForm.value);
    this.addCustomer(this.registerForm.value);
  }

  ngOnInit() {
  }

  public addCustomer(customer: Customer): Observable<Customer> {
    let cust = this.http.post<Customer>(`${this.apiServerUrl}/customers/addCustomer`, customer).subscribe(response => {
      console.log(response);
      let res = JSON.stringify(response);
      localStorage.setItem('currentUser', res);
    });
    return this.customer;
  }

}

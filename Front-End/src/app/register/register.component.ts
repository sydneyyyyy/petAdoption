import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Customer } from '../customer';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  private apiServerUrl = "http://localhost:8080";
  customer: any;

  constructor(private http: HttpClient, private router: Router) { 
    this.registerForm = new FormGroup({
      fname: new FormControl('', [Validators.required]),
      lname: new FormControl('', [Validators.required]),
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      // information: new FormControl('', [Validators.required]),
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
      window.location.reload();
    });
    this.router.navigate(['pets']);
    return this.customer;
  }

  

}
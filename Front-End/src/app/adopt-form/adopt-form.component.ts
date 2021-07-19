import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Application } from '../application';

@Component({
  selector: 'app-adopt-form',
  templateUrl: './adopt-form.component.html',
  styleUrls: ['./adopt-form.component.css']
})
export class AdoptFormComponent implements OnInit {
  
  applicationForm: FormGroup;
  private apiServerUrl = environment.apiBaseUrl;
  application: any;

  constructor(private http: HttpClient, private router: Router) {
    this.applicationForm = new FormGroup({
      information: new FormControl('', [Validators.required]),
    });
   }

  ngOnInit(): void {
  }

  addApplication(application: Application) {
    let app = this.http.post<Application>(`${this.apiServerUrl}/applications/addApplication`, application).subscribe(response => {
      console.log(response);
      // let res = JSON.stringify(response);
      // localStorage.getItem('currentUser');
      // window.location.reload();
    });
    // this.router.navigate(['applications']);
    return this.application;
    
  }

  onSubmit() {
    console.log(this.applicationForm.value);
    this.addApplication(this.applicationForm.value);


  }

  // public addCustomer(customer: Customer): Observable<Customer> {
  //   let cust = this.http.post<Customer>(`${this.apiServerUrl}/customers/addCustomer`, customer).subscribe(response => {
  //     console.log(response);
  //     let res = JSON.stringify(response);
  //     localStorage.setItem('currentUser', res);
  //     window.location.reload();
  //   });
  //   this.router.navigate(['pets']);
  //   return this.customer;
  // }

}

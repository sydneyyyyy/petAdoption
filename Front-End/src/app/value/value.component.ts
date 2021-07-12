import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from "src/environments/environment";

@Component({
  selector: 'app-value',
  templateUrl: './value.component.html',
  styleUrls: ['./value.component.css']
})
export class ValueComponent implements OnInit {
  private apiServerUrl =  environment.apiBaseUrl;

  customers: any;
  employees: any;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getCustomers();
    this.getEmployees();
  }

  

  getCustomers() {
    return this.http.get(`${this.apiServerUrl}/customers`).subscribe(response => {
      console.log(response);
      this.customers = response;
    }, error => {
      console.log(error);
    });
  }

  getEmployees() {
    return this.http.get(`${this.apiServerUrl}/employees`).subscribe(response => {
      console.log(response);
      this.employees = response;
    }, error => {
      console.log(error);
    });
  }

}

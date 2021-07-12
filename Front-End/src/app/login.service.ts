import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  private apiServerUrl = environment.apiBaseUrl;
  customers: Customer;

  constructor(private http: HttpClient) { }

  public getCustomer(customer: Customer['username']): Observable<Customer> {
    return this.http.post<Customer>(`${this.apiServerUrl}/login`, customer);
  }
}

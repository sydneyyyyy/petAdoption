import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  private apiServerUrl = "http://localhost:8080";
  customers: Customer;

  constructor(private http: HttpClient) { }

  public getCustomer(username: string): Observable<Customer> {
    return this.http.get<Customer>(`${this.apiServerUrl}/login`);
  }
}

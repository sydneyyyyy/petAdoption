import { Injectable } from '@angular/core';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  public login(customerInfo: Customer) {
    localStorage.setItem('currentUser', 'access_token');
  }

  
}

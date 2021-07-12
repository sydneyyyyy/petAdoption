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

  public isLoggedIn() {
    return localStorage.getItem('currentUser') !== null;
  }

  public logout() {
    localStorage.removeItem('currentUser');
  }
}

// import { Injectable } from '@angular/core';
// import { environment } from 'src/environments/environment';
// import { HttpClient } from '@angular/common/http';
// import { Customer } from './user';
// import { Observable, BehaviorSubject } from "rxjs";
// import { map } from 'rxjs/operators';

// @Injectable({
//   providedIn: 'root'
// })
// export class UserService {
//   public user: Observable<Customer>;
//   private currentUserSubject: BehaviorSubject<Customer>;

//   constructor(private http: HttpClient) { 
//     this.currentUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')))
//     this.user = this.currentUserSubject.asObservable();
//   }

//   public get currentUserValue(): Customer {
//     return this.currentUserSubject.value;
//   }
//   // public getUsers(): Observable<Customer[]> {
//   //   return this.http.get<Customer[]>(`${this.apiServerUrl}/customers`);
//   // }

//   login(username: string, password: string) {
//     return this.http.post<Customer>(`${environment.apiBaseUrl}/customers/login`, {username, password})
//       .pipe(map(customer => {
//         localStorage.setItem('currentUser', JSON.stringify(customer));
//         this.currentUserSubject.next(customer);
//         return customer;
//       }));
//   }

//   logout() {
//     localStorage.removeItem('currentUser');
//     this.currentUserSubject.next(null);
//   }
// }

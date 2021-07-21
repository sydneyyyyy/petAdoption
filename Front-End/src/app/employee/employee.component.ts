import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { AuthService } from '../auth.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  loginForm: FormGroup;
  employees: any;
  loginStatus$: Observable<boolean>;
  private loggedIn: BehaviorSubject<boolean> = new 
  BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient, private router: Router, 
    private authService: AuthService) {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
  }

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  ngOnInit() {
    this.loginStatus$ = this.authService.isLoggedIn;
  }

  onSubmit() {
    console.log(this.loginForm.value);
    this.loginEmp(this.loginForm.value);
  }

  public loginEmp(employee: Employee): Observable<Employee> {
    localStorage.setItem('isEmployee', 'true');

    this.authService.loginEmp(employee);
    return null;
  }

}

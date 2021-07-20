import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isLoggedIn$: Observable<boolean>;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.loginStatus$ = this.authService.isLoggedIn;
    this.isEmployee = localStorage.getItem('isEmployee');
  }

  loginStatus$: Observable<boolean>;
  isEmployee: string;

  onLogout() {
    this.authService.logout();
  }
}

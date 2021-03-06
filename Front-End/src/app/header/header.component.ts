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
    
  }

  loginStatus$: Observable<boolean>;
  

  onLogout() {
    this.authService.logout();
  }
}

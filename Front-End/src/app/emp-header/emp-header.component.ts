import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-emp-header',
  templateUrl: './emp-header.component.html',
  styleUrls: ['./emp-header.component.css']
})
export class EmpHeaderComponent implements OnInit {

  isEmpLoggedIn: Observable<boolean>;
  isEmployee: Observable<boolean>;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.isEmployee = this.authService.isEmpLoggedIn;
    console.log(localStorage.getItem('isEmployee'));
  }

  onLogout() {
    this.authService.logout();
  }

}

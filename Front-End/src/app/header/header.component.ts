import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public isLoggedIn = localStorage.getItem('currentUser');

  constructor() { }

  ngOnInit(): void {
    
  }

  public logout() {
    console.log("logout clicked..");
    localStorage.removeItem('currentUser');
  }
}

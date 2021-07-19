import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public isLoggedIn = localStorage.getItem('currentUser');


  constructor(private router: Router) { }

  ngOnInit(): void {

  }
  
  public logout() {
    console.log("logout clicked..");
   
    // !this.isLoggedIn;
    localStorage.removeItem('currentUser');
    this.router.navigate(['customers/login']);
     window.location.reload();
     this.router.navigate(['customers/login']);
  }
}


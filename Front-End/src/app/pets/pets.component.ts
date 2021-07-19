import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {

  
  pets: any;
  
  constructor(private http: HttpClient, private router: Router) { 
    
  }

  ngOnInit() {
  }

  petDetail() {
    this.router.navigate(['pets/{id}']);
  }

}

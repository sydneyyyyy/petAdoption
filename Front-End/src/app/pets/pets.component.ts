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


  private apiServerUrl = environment.apiBaseUrl;
  pets: any;
  

  constructor(private http: HttpClient, private router: Router) { 
    
  }

  ngOnInit() {
    this.getAvailablePets();
  }

  petDetail() {
    this.router.navigate(['pets/{id}']);
  }

  getAvailablePets() {
    return this.http.get(`${this.apiServerUrl}/pets/available/true`).subscribe(response => {
      console.log(response);
      this.pets = response;
    }, error => {
      console.log(error);
    });

  }

}

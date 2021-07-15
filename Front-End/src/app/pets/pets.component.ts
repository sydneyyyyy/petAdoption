import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {

  private apiServerUrl =  environment.apiBaseUrl;
  pets: any;
  
  constructor(private http: HttpClient) { 
    
  }

  ngOnInit() {
    this.getPets();
  }

  getPets() {
    return this.http.get(`${this.apiServerUrl}/pets`).subscribe(response => {
      console.log(response);
      this.pets = response;
    }, error => {
      console.log(error);
    });
  }

}

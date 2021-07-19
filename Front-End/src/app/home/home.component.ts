import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Pet } from '../pet';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private apiServerUrl = environment.apiBaseUrl;
  pets: any;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getAdopted()
  }

  getAdopted() {
    return this.http.get(`${this.apiServerUrl}/pets/available/false`).subscribe(response => {
      console.log(response);
      this.pets = response;
  
    })
  }

}



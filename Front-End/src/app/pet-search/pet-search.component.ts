import { Component, OnInit } from '@angular/core';
import { Pet } from '../pet';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-pet-search',
  templateUrl: './pet-search.component.html',
  styleUrls: ['./pet-search.component.css']
})


export class PetSearchComponent implements OnInit {

  species: any;
  pets: any;
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getPets();
  }
  
  getPets() {
    return this.http.get(`${this.apiServerUrl}/available/true`).subscribe(response => {
      console.log(response);
      this.pets = response;
    }, error => {
      console.log(error);
    });
  }

  getBySpecies() {
    return this.http.get(`${this.apiServerUrl}/species/:id`).subscribe(response => {
      console.log(response);
      this.pets = response;
    })
  }


        

}


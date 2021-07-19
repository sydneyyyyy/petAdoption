import { Component, OnInit } from '@angular/core';
import { Pet } from '../pet';
import { Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';



@Component({
  selector: 'app-pet-search',
  templateUrl: './pet-search.component.html',
  styleUrls: ['./pet-search.component.css']
})


export class PetSearchComponent {

  species: any;
  pets: any;
  private apiServerUrl = environment.apiBaseUrl;
  id: any;

  constructor(private http: HttpClient, 
      private _Activatedroute: ActivatedRoute) {
  }

  ngOnInit() {
    this.id=this._Activatedroute.snapshot.paramMap.get("id");
    this.showResults(this.id);
    this.getSpecies();
  }

  showResults(id: number) {
    this.getBySpecies(id);
  }

  getSpecies() {
    return this.http.get(`${this.apiServerUrl}/species`).subscribe(response => {
      console.log(response);
      this.species = response;
    })
  }

  getBySpecies(id: number) {
    return this.http.get(`${this.apiServerUrl}/pets/species/${id}`).subscribe(response => {
      console.log(response);
      this.pets = response;
      let petsDiv = document.getElementById('pet-container');
      petsDiv.setAttribute('style', 'display: none;');
    })
  }

  


        

}


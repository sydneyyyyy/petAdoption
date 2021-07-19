import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-pet-search',
  templateUrl: './pet-search.component.html',
  styleUrls: ['./pet-search.component.css']
})


export class PetSearchComponent {

  species: any;
  pets: any;
  breeds: any;
  private apiServerUrl = environment.apiBaseUrl;
  id: any;

  constructor(private http: HttpClient, 
      private _Activatedroute: ActivatedRoute) {
  }

  ngOnInit() {
    this.id=this._Activatedroute.snapshot.paramMap.get("id");
    this.showSpeciesResults(this.id);
    this.getSpecies();
    this.getBreeds();
  }

  showSpeciesResults(id: number) {
    this.getBySpecies(id);
  }

  showBreedResults(id: number) {
    this.getByBreed(id);
  }

  getBreeds() {
    return this.http.get(`${this.apiServerUrl}/breeds`).subscribe(response => {
      console.log(response);
      this.breeds = response;
    })
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
      let breedDiv = document.getElementById('breed-dropdown');
      breedDiv.setAttribute('style', 'display: contents'); 
    })
  }

  getByBreed(id: number) {
    return this.http.get(`${this.apiServerUrl}/pets/breed/${id}`).subscribe(response => {
      console.log(response);
      this.pets = response;
      let petsDiv = document.getElementById('pet-container');
      petsDiv.setAttribute('style', 'display: none;');

    })
  }

  


        

}


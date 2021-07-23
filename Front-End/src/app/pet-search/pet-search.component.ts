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
  gender: any;
  private apiServerUrl = "http://localhost:8080";
  id: any;
  sid: any;
  bid: any;

  constructor(private http: HttpClient, 
      private _Activatedroute: ActivatedRoute) {
        
  }

  ngOnInit() {
    this.id=this._Activatedroute.snapshot.paramMap.get("id");
    this.showSpeciesResults(this.id);
    this.getSpecies();
  }

  getMale() {
    return this.http.get(`${this.apiServerUrl}/breeds/${this.bid}/gender/M`).subscribe(response => {
      console.log(response);
      this.pets = response;
    })
  }

  getFemale() {
    return this.http.get(`${this.apiServerUrl}/breeds/${this.bid}/gender/F`).subscribe(response => {
      console.log(response);
      this.pets = response;
    })
  }

  showSpeciesResults(id: number) {
    this.getBySpecies(id);
  }

  showBreedResults(id: number) {
    this.getByBreed(id);
  }

  getBreeds(sid: number) {
    return this.http.get(`${this.apiServerUrl}/breeds/species/${sid}`).subscribe(response => {
      console.log(response);
      this.breeds = response;
      
    })
  }

  getSpecies() {
    let species = this.http.get(`${this.apiServerUrl}/species`).subscribe(response => {
      console.log(response);
      this.species = response;
    })
    return species;
  }

  getBySpecies(id: number) {
    let species = this.http.get(`${this.apiServerUrl}/pets/species/${id}`).subscribe(response => {
      console.log(response);
      this.pets = response;
      let petsDiv = document.getElementById('pet-container');
      petsDiv.setAttribute('style', 'display: none;');
      let breedDiv = document.getElementById('breed-dropdown');
      breedDiv.setAttribute('style', 'display: contents'); 
    })
    this.getBreeds(id)
    return species;
  }

  getByBreed(id: number) {
    return this.http.get(`${this.apiServerUrl}/pets/breed/${id}`).subscribe(response => {
      console.log(response);
      this.pets = response;
      this.bid = id;
      let petsDiv = document.getElementById('pet-container');
      petsDiv.setAttribute('style', 'display: none;');
      let genderDiv = document.getElementById('gender-dropdown');
      genderDiv.setAttribute('style', 'display: contents'); 
    })
  }

}


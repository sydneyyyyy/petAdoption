import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent implements OnInit {

  addPetForm: FormGroup;
  breeds: any;
  species: any;
  sid: any;
  M: any;
  F: any;
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { 
    this.addPetForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      species: new FormControl('', [Validators.required]),
      breeds: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required])
    });
  }

  ngOnInit() {
    this.getSpecies();
    this.getBreeds();
  }

  onAddPet() {
    console.log(this.addPetForm.value);
  }

  getSpecies() {
    return this.http.get(`${this.apiServerUrl}/species`).subscribe(response => {
      console.log(response);
      this.species = response;
    })
  }

  getBreeds() {
    return this.http.get(`${this.apiServerUrl}/breeds`).subscribe(response => {
      console.log(response);
      this.breeds = response;
      
    })
  }

}

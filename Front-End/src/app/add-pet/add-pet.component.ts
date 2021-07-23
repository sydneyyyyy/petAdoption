import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { Pet } from '../pet';
import { PetDetailComponent } from '../pet-detail/pet-detail.component';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent implements OnInit {

  addPetForm: FormGroup;
  bname: any;
  species: any;
  sid: any;
  gender: any = ['M', 'F'];
  size: any = ['S', 'M', 'L', 'XL'];
  pet: any;
  private apiServerUrl = "http://localhost:8080";

  constructor(private http: HttpClient) { 
    this.addPetForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      species: new FormControl('', [Validators.required]),
      bname: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      size: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required])
    });
  }

  ngOnInit() {
    this.getSpecies();
    this.getBreeds();
  }

  onSubmit() {
    console.log(this.addPetForm.value);
    this.onAddPet(this.addPetForm.value);
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
      this.bname = response;
      
    })
  }

  onAddPet(pet: any) {
    console.log(pet);
    let p = {
      name: pet.name,
      breed: {
        bname: pet.bname,
      },
      size: pet.size,
      age: pet.age,
      gender: pet.gender,
      price: pet.price,
      available: true,
      image: pet.image
    };
    return this.http.post<Pet>(`${this.apiServerUrl}/pets/addPet`, p).subscribe(response => {
      console.log(response);
      this.pet = response;
    })
  }

}
 

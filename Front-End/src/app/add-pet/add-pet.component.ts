import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { Pet } from '../pet';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.css']
})
export class AddPetComponent implements OnInit {

  addPetForm: FormGroup;
  // speciesForm: FormGroup;
  // breedsForm: FormGroup;
  // species: any;
  breeds: any;
  size: any = ['S', 'M', 'L', 'XL'];
  sid: any;
  gender: any = ['M', 'F'];
  pet: any;
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { 
    this.addPetForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      bname: new FormControl('', [Validators.required]),
      // breedsForm: new FormGroup({
      //   id: new FormControl('', [Validators.required]),
      //   bname: new FormControl('', [Validators.required]),
      //   speciesForm: new FormGroup({
      //     id: new FormControl('', [Validators.required]),
      //     sName: new FormControl('', [Validators.required])
      //   })
      // }),
      size: new FormControl('', [Validators.required]),
      gender: new FormControl('', [Validators.required]),
      age: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      image: new FormControl('', [Validators.required])
    });
  }

  ngOnInit() {
    // this.getSpecies();
    this.getBreeds();
  }

  onSubmit() {
    console.log(this.addPetForm.value);
    this.onAddPet(this.addPetForm.value);
  }

  onAddPet(pet: Pet) {
    return this.http.post<Pet>(`${this.apiServerUrl}/pets/addPet`, pet).subscribe(response => {
      console.log(response);
      this.pet = response;
    })
  }

  // getSpecies() {
  //   return this.http.get(`${this.apiServerUrl}/species`).subscribe(response => {
  //     console.log(response);
  //     this.species = response;
  //   })
  // }

  getBreeds() {
    return this.http.get(`${this.apiServerUrl}/breeds`).subscribe(response => {
      console.log(response);
      this.breeds = response;
      
    })
  }

}

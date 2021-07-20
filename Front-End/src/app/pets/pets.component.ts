import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { PetService } from '../pet.service';
import { NgForm } from '@angular/forms';
import { Pet } from '../pet';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent implements OnInit {


  private apiServerUrl = environment.apiBaseUrl;
  pets: any;
  isEmployee: any;
  

  constructor(private http: HttpClient, private router: Router, private petService: PetService) { 
    
  }

  ngOnInit() {
    this.getAvailablePets();
    this.isEmployee = localStorage.getItem('isEmployee');

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

  public onAddPet(addForm: NgForm): void {
    document.getElementById('add-pet-form').click();
    this.petService.addPet(addForm.value).subscribe(
      (response: Pet) => {
        console.log(response);
        this.getAvailablePets();
        addForm.reset();
      }
    );
  }

  public onOpenModal(pet: Pet, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addPetModal');
    }
    // if (mode === 'edit') {
    //   this.editEmployee = employee;
    //   button.setAttribute('data-target', '#updateEmployeeModal');
    // }
    // if (mode === 'delete') {
    //   this.deleteEmployee = employee;
    //   button.setAttribute('data-target', '#deleteEmployeeModal');
    // }
    container.appendChild(button);
    button.click();
  }

}

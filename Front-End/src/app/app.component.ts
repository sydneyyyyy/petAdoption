import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Pet } from './pet';
import { PetService } from './pet.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public pets: Pet[];
  constructor(private petService: PetService) { }

  ngOnInit() {
    this.getPets();
  }

  public getPets(): void {
    this.petService.getPets().subscribe(
      (response: Pet[]) => {
        this.pets = response;
        console.log(response);
      },
      (error: HttpErrorResponse) => {
        console.log(error.message);
      }
    )
  }
}

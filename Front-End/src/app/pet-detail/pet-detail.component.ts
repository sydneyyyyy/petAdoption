import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Pet } from '../pet';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.css']
})
export class PetDetailComponent implements OnInit {

  private apiServerUrl = environment.apiBaseUrl;
  id: any;
  pets: any;
  canAdopt: any;
  isEmployee: any;
  
  constructor(private http: HttpClient, private _Activatedroute: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.id=this._Activatedroute.snapshot.paramMap.get("id");
    this.getCanAdopt(this.id);
    this.getPetById(this.id);
    this.isEmployee = localStorage.getItem['isEmployee'];
  }

  getPetById(id: number) {
    return this.http.get<Pet>(`${this.apiServerUrl}/pets/${id}`).subscribe(response => {

      this.pets = response;
      localStorage["selectedPet"]=JSON.stringify(this.pets);
    })
  }

  adoptPet(){
    this.router.navigate(["applications"]);
  }

  getCanAdopt(id: number){
    return this.http.get(`${this.apiServerUrl}/applications/canAdopt/${id}`).subscribe(response => {
      console.log(response);      
      this.canAdopt = response;
    });
  }

  deletePet(){
    let id = this.id;
    return this.http.delete(`${this.apiServerUrl}/pets/deletePet/${id}`);
  }

}

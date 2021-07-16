import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Pet } from '../pet';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.css']
})
export class PetDetailComponent implements OnInit {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    // this.getPetById(id);
  }

  // getPetById(id: number): Observable<Pet> {
  //   return this.http.get<Pet>(`${this.apiServerUrl}/pets/${id}`).subscribe(response => {
  //     console.log(response);
  //   })
    
  // }

}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-dogs',
  templateUrl: './dogs.component.html',
  styleUrls: ['./dogs.component.css']
})
export class DogsComponent implements OnInit {
  id: any;
  species: any;
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient, private _Activatedroute: ActivatedRoute) { }

  ngOnInit(): void {
    this.id=this._Activatedroute.snapshot.paramMap.get("id");
  }

  getBySpecies(id: number) {
    return this.http.get(`${this.apiServerUrl}/pets/species/${id}`).subscribe(response => {
      console.log(response);
      this.species = response;
    })
  }

}

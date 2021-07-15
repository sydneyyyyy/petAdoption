// import { Injectable } from "@angular/core";
// import { Observable } from "rxjs";
// import { HttpClient } from '@angular/common/http';
// import { Pet } from "./pet";
// import { environment } from "src/environments/environment";

// @Injectable({
//     providedIn: 'root'
// })

// export class PetService {
//     private apiServerUrl =  environment.apiBaseUrl;

//     constructor(private http: HttpClient) { }

//     public getPets(): Observable<Pet[]> {
//         return this.http.get<Pet[]>(`${this.apiServerUrl}/pets`);
//     }

//     public addPets(pet: Pet): Observable<Pet> {
//         return this.http.post<Pet>(`${this.apiServerUrl}/addPet`, pet);
//     }

//     public updatePet(pet: Pet): Observable<Pet> {
//         return this.http.put<Pet>(`${this.apiServerUrl}/pets/id`, pet);
//     }

//     public deletePet(id: number): Observable<void> {
//         return this.http.delete<void>(`${this.apiServerUrl}/pets/${id}`);
//     }
// }
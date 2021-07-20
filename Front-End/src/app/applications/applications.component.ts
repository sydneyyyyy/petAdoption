import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Application } from '../application';

@Component({
  selector: 'app-applications',
  templateUrl: './applications.component.html',
  styleUrls: ['./applications.component.css']
})
export class ApplicationsComponent implements OnInit {
  private apiServerUrl = environment.apiBaseUrl;
  applicationList: any;
  id: any;
  aid: any;
  application: any;

  constructor(private http: HttpClient, private _Activatedroute: ActivatedRoute) { }

  ngOnInit() {
    this.getEmpApps();
    this.id=this._Activatedroute.snapshot.paramMap.get("id");
  }

  getEmpApps() {
    let emp = JSON.parse(localStorage.getItem('currentUser'));
    return this.http.get(`${this.apiServerUrl}/applications/employee/${emp.id}`).subscribe(response => {
      console.log(response);
      this.applicationList = response;
    })
  }

  approveApp(aid: number) {
    let emp = JSON.parse(localStorage.getItem('currentUser'));
    let app = this.http.get(`${this.apiServerUrl}/applications/${aid}`).subscribe(response => {
      console.log(response);
      this.application = response;
      if (this.application.bsupapproval === false) {
        console.log("false");
        const body = {
          id: aid,
          subdate: this.application.subdate,
          bsupapproval: true,
          secondapproval: false,
          status: "secondApproval",
          information: this.application.information,
          pet: this.application.pet,
          customer: this.application.customer,
        }
        let upApp = this.http.put<Application>(`${this.apiServerUrl}/applications/${aid}`, body).subscribe(response => {
          console.log(response);
          this.application = response;
        })
       
      } else {
        console.log("else");
        const body = {
          id: aid,
          subdate: this.application.subdate,
          bsupapproval: this.application.bsupapproval,
          secondapproval: true,
          status: "approved",
          information: this.application.information,
          pet: this.application.pet,
          customer: this.application.customer
        }
        let upApp = this.http.put<Application>(`${this.apiServerUrl}/applications/${aid}`, body).subscribe(response => {
          console.log(response);
          this.application = response;
        })
      }
    })
  }

  denyApp(aid: number) {
    let emp = JSON.parse(localStorage.getItem('currentUser'));
    let app = this.http.get(`${this.apiServerUrl}/applications/${aid}`).subscribe(response => {
      console.log(response);
      this.application = response;
      if (this.application.bsupapproval === false) {
        console.log("false");
        const body = {
          id: aid,
          subdate: this.application.subdate,
          bsupapproval: false,
          secondapproval: false,
          status: "denied",
          information: this.application.information,
          pet: {
            id: this.application.pet.id,
            name: this.application.pet.name,
            breed: this.application.pet.breed,
            size: this.application.pet.size,
            age: this.application.pet.age,
            gender: this.application.pet.gender,
            available: true,
            image: this.application.pet.image,
          },
          customer: this.application.customer,
        }
        let upApp = this.http.put<Application>(`${this.apiServerUrl}/applications/${aid}`, body).subscribe(response => {
          console.log(response);
          this.application = response;
        });
       
      } else {
        console.log("else");
        const body = {
          id: aid,
          subdate: this.application.subdate,
          bsupapproval: this.application.bsupapproval,
          secondapproval: false,
          status: "denied",
          information: this.application.information,
          pet: {
            id: this.application.pet.id,
            name: this.application.pet.name,
            breed: this.application.pet.breed,
            size: this.application.pet.size,
            age: this.application.pet.age,
            gender: this.application.pet.gender,
            available: true,
            image: this.application.pet.image,
          },
          customer: this.application.customer
        }
        let upApp = this.http.put<Application>(`${this.apiServerUrl}/applications/${aid}`, body).subscribe(response => {
          console.log(response);
          this.application = response;
        })
      }
    })
  }


}

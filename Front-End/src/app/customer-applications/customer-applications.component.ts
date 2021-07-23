import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Application } from '../application';

@Component({
  selector: 'app-customer-applications',
  templateUrl: './customer-applications.component.html',
  styleUrls: ['./customer-applications.component.css']
})
export class CustomerApplicationsComponent implements OnInit {

  private apiServerUrl = "http://localhost:8080";

  id: any;
  applications: any;
  infoRequested: boolean = false;
  moreInfo: string;
  apps: any = [];
  

  constructor(private http: HttpClient, private _Activatedroute: ActivatedRoute) { }

  ngOnInit() {
    this.id=this._Activatedroute.snapshot.paramMap.get("id");
    this.getCustApps();
  }

  onSubmit(aid: number) {
    let app = this.http.get(`${this.apiServerUrl}/applications/${aid}`).subscribe(response => {
      console.log(response);
      this.applications = response;
      let body = {
        id: aid,
        subdate: this.applications.subdate,
        bsupapproval: this.applications.bsupapproval,
        secondapproval: this.applications.secondapproval,
        status: "",
        information: this.applications.information + " user response: " + this.moreInfo,
        pet: this.applications.pet,
        customer: this.applications.customer,
      }
      if (body.bsupapproval) {
        body.status = "secondApproval";
      } else {
        body.status = "submitted";
      }
      return this.http.put<Application>(`${this.apiServerUrl}/applications/${aid}`, body).subscribe(response => {
        console.log(response);
        this.applications = response;
      })
    })
  }

  getCustApps() {
    let cust = JSON.parse(localStorage.getItem('currentUser'));
    let app = this.http.get(`${this.apiServerUrl}/applications/customer/${cust.id}`).subscribe(response => {
      console.log(response);
      this.applications = response;
      console.log(this.applications[0].status);
      for (let i: number = 0; i < this.applications.length; i++) {
        console.log(i);
        let app = {
          id: this.applications[i].id,
          subdate: this.applications[i].subdate,
          bsupapproval: this.applications[i].bsupapproval,
          secondapproval: this.applications[i].secondapproval,
          status: this.applications[i].status,
          information: this.applications[i].information,
          pet: this.applications[i].pet,
          customer: this.applications[i].customer,
          infoRequested: false,
        }
        if (this.applications[i].status == "more info requested") {
          console.log("inside if");
          app.infoRequested = true;
        }
        this.apps.push(app);
  
      }
    })
    
    
    
    return app;
  }

}

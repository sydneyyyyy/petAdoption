import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-customer-applications',
  templateUrl: './customer-applications.component.html',
  styleUrls: ['./customer-applications.component.css']
})
export class CustomerApplicationsComponent implements OnInit {

  private apiServerUrl = environment.apiBaseUrl;

  id: any;
  applicationList: any;

  constructor(private http: HttpClient, private _Activatedroute: ActivatedRoute) { }

  ngOnInit() {
    this.id=this._Activatedroute.snapshot.paramMap.get("id");
    this.getCustApps();
  }

  getCustApps() {
    let cust = JSON.parse(localStorage.getItem('currentUser'));
    return this.http.get(`${this.apiServerUrl}/applications/customer/${cust.id}`).subscribe(response => {
      console.log(response);
      this.applicationList = response;
    })
  }

}

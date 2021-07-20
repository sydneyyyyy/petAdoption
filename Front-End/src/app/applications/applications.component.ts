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
    return this.http.put<Application>(`${this.apiServerUrl}/applications/${aid}`, aid).subscribe(response => {
      console.log(response);
    })
  }

  denyApp(aid: number) {
    return this.http.put<Application>(`${this.apiServerUrl}/applications/${aid}`, aid).subscribe(response => {
      console.log(response);
    })
  }


}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
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

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getEmpApps();
  }

  getEmpApps() {
    let emp = JSON.parse(localStorage.getItem('currentUser'));
    return this.http.get(`${this.apiServerUrl}/applications/employee/${emp.id}`).subscribe(response => {
      console.log(response);
      this.applicationList = response;
    })
  }

  approveApp(application: Application) {
    return this.http.post<Application>(`${this.apiServerUrl}/applications/${application.id}`, application)
  }

  denyApp(id: number) {

  }


}

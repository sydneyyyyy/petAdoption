import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';
import { Application } from '../application';

@Component({
  selector: 'app-adopt-form',
  templateUrl: './adopt-form.component.html',
  styleUrls: ['./adopt-form.component.css']
})
export class AdoptFormComponent implements OnInit {
  
  applicationForm: FormGroup;
  private apiServerUrl = "http://localhost:8080";
  application: any;

  constructor(private http: HttpClient, private router: Router) {
    this.applicationForm = new FormGroup({
      information: new FormControl('', [Validators.required]),
    });
    this.application = new Object();
   
  }

  ngOnInit(): void {
  }

  addApplication(application: Application) {
    console.log(application);
    let app = this.http.post<Application>(`${this.apiServerUrl}/applications/addApplication`, application).subscribe(response => {
      console.log(response);
    });
    return this.application;
    
  }

  onSubmit() {
    var date = new Date().toISOString().substring(0,10);
    var info = this.applicationForm.value;  

    console.log(info);
    this.application.subdate = date;
    this.application.bsupapproval = false;
    this.application.secondapproval = false;
    this.application.information =  this.applicationForm.get('information').value
    this.application.status = "submitted";
    this.application.pet = JSON.parse(localStorage.getItem("selectedPet"));
    this.application.customer = JSON.parse(localStorage.getItem("currentUser"));
  
    this.addApplication(this.application);
    
  }

}

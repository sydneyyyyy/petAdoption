import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { PetsComponent } from './pets/pets.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { PetDetailComponent } from './pet-detail/pet-detail.component';
import { AdoptFormComponent } from './adopt-form/adopt-form.component';
import { PetSearchComponent } from './pet-search/pet-search.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { EmployeeComponent } from './employee/employee.component';
import { ApplicationsComponent } from './applications/applications.component';
import { AddPetComponent } from './add-pet/add-pet.component';
import { EmpHeaderComponent } from './emp-header/emp-header.component';
import { CustomerApplicationsComponent } from './customer-applications/customer-applications.component';



@NgModule({
  declarations: [
    AppComponent,
    PetsComponent,
    LoginComponent,
    HeaderComponent,
    HomeComponent,
    RegisterComponent,
    PetDetailComponent,
    AdoptFormComponent,
    PetSearchComponent,
    EmployeeComponent,
    ApplicationsComponent,
    AddPetComponent,
    EmpHeaderComponent,
    CustomerApplicationsComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}

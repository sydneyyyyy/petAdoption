import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { PetsComponent } from './pets/pets.component';
import { PetDetailComponent } from './pet-detail/pet-detail.component';
import { AdoptFormComponent } from './adopt-form/adopt-form.component';
import { EmployeeComponent } from './employee/employee.component';
import { ApplicationsComponent } from './applications/applications.component';
import { AddPetComponent } from './add-pet/add-pet.component';
import { CustomerApplicationsComponent } from './customer-applications/customer-applications.component';


const routes: Routes = [
  { path: 'customers/login', component: LoginComponent },
  { path: 'pets', component: PetsComponent },
  { path: 'customers/addCustomer', component: RegisterComponent },
  { path: "pets/:id", component: PetDetailComponent },
  { path: "applications", component: AdoptFormComponent},
  { path: 'home', component: HomeComponent },
  { path: 'employees/login', component: EmployeeComponent},
  { path: 'applications/employee', component: ApplicationsComponent },
  { path: 'applications/customer', component: CustomerApplicationsComponent },
  { path: 'addPet', component: AddPetComponent },
  { path: '**', component: HomeComponent },
  
  // { path: 'pets/species/:id', component: SpeciesComponent }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

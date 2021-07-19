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
import { CustomerComponent } from './customer/customer.component';
import { PetSearchComponent } from './pet-search/pet-search.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DogsComponent } from './dogs/dogs.component';
import { SpeciesComponent } from './species/species.component';



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
    CustomerComponent,
    PetSearchComponent,
    DogsComponent,
    SpeciesComponent,

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

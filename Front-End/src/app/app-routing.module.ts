import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AppComponent } from './app.component';
// import { AuthGuard } from './auth.guard';
import { HomeComponent } from './home/home.component';
import { PetsComponent } from './pets/pets.component';

const routes: Routes = [
  { path: 'customers/login', component: LoginComponent },
  { path: 'pets', component: PetsComponent },
  { path: 'customers/addCustomer', component: RegisterComponent },
  { path: '', component: HomeComponent },
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

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarDetailsComponent } from './car-details/car-details.component';
import { CarsListComponent } from './cars-list/cars-list.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { HeaderComponent} from './header/header.component'

const routes: Routes = [
  {
    path:' ', redirectTo:'home', pathMatch:'full'
  },
  {
    path:'home',
    component:WelcomeComponent,
  },
  {
    path: "detail/:id",
    component: CarDetailsComponent,
  }, 
  {
    path: "list",
    component: CarsListComponent,
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

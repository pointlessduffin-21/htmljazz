import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { CarsListComponent } from './cars-list/cars-list.component';
import { CarDetailsComponent } from './car-details/car-details.component';
import { HeaderComponent } from './header/header.component';
import { RouterModule } from '@angular/router'; 

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    CarsListComponent,
    CarDetailsComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot([
      {path: '', component: WelcomeComponent},
      {path: '', component: AppComponent}
    ])
  ],
  providers: [],
  bootstrap: [AppComponent, WelcomeComponent, CarsListComponent, CarDetailsComponent]
})
export class AppModule { }

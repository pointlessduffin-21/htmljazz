import { Component, OnInit } from '@angular/core';
import {CarserviceService} from '../carservice.service'; 
import {Car} from '../car';

@Component({
  selector: 'app-cars-list',
  templateUrl: './cars-list.component.html',
  styleUrls: ['./cars-list.component.css']
})
export class CarsListComponent implements OnInit {

  constructor(private carservice:CarserviceService){}

  cars: Car[] = [];

  ngOnInit(): void {
    this.cars=this.carservice.getAllCar();
    throw new Error('Method not implemented.');
  }



  getHeroes(): void {
    this.carservice.getAllCar()
        //.subscribe(this.cars , this.cars = this.cars);
  }
  
}
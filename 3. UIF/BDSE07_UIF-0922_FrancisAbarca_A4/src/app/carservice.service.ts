import { Injectable } from '@angular/core';
import {Car} from "./car";
import {CARLISTS} from './mock-cars';

@Injectable({
  providedIn: 'root'
})
export class CarserviceService {

  constructor() { }

  getAllCar():Car[]{
    return CARLISTS;
  }

  // Grab Car by ID
  getCarByID(cid:number):Car{
    const car=CARLISTS.find(c=>c.carid===cid)!;
    return car;
  }

  //Delete Car listed

}

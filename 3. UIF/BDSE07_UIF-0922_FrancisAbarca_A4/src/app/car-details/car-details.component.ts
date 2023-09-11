import { Component, OnInit } from '@angular/core';
import {Location} from '@angular/common';
import { ActivatedRoute } from '@angular/router';
import { Car } from '../car';
import { CarserviceService } from '../carservice.service';


@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute,
    private carservice:CarserviceService,
    private location: Location){}

    car:Car | undefined;

    ngOnInit(): void {

    // Retrieves the car by its corresponding ID value
    const cid=Number(this.route.snapshot.paramMap.get("id"));
    this.car=this.carservice.getCarByID(cid);
    throw new Error('Method not Implemented');

  }
}

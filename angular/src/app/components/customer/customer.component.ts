import { Component, OnInit } from '@angular/core';
import {Customer} from "../../models/customer.model";
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customer: Customer;

  constructor( private customerService: CustomerService) {
    this.customer = customerService.customer;
  }

  ngOnInit(): void {
    this.customerService.getCustomerById()
      .subscribe(data => {
        this.customer = data;
      })
  }

}

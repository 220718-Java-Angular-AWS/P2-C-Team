import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerService} from "../../services/customer.service";
import {Customer} from "../../models/customer.model";
import {OrderService} from "../../services/order.service";
import {Order} from "../../models/order.model";

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  orders: Order | any;
  total:number = 0;
  customer: Customer | any;
  form = new FormGroup({
    firstName: new FormControl('', [Validators.required]),
    lastName: new FormControl('',[Validators.required]),
    email: new FormControl('',[Validators.required]),
    street: new FormControl('',[Validators.required]),
    city: new FormControl('',[Validators.required]),
    state: new FormControl('',[Validators.required]),
    zipCode: new FormControl('',[Validators.required]),
    cardNumber: new FormControl('',[Validators.required]),
    dateExpiration: new FormControl('',[Validators.required]),

  })

  constructor(
    private customerServer: CustomerService,
    private orderService: OrderService
  ) {
    this.customerServer.getCustomerById(`${localStorage.getItem('MKPG')}`).subscribe({
      next: data => {
        this.customer = data;
      }
    })
  }

  ngOnInit(): void {
    this.orderService.myOrders$.subscribe({
      next: data => {
        this.orders = data;
        let total = 0;
        data.forEach( order => {
          total += +order.quantity * order.item.price;
        })
        this.total = total;
      }
    })
  }

  save(){

  }

  deleteItem(id: number){
    this.orderService.deleteOrder(`${id}`).subscribe({
      next: _ => {
        this.orderService.deleteMyOrder(id);
      }
    })
  }

}

import { Injectable } from '@angular/core';
import {Customer} from "../models/customer.model";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private _customer: Customer = {
    customerId: null,
    firstName: "",
    lastName: "",
    email: "",
    password: "",
    phone: 0,
    birthDate: Date.now(),
    created: Date.now(),
  };

  constructor(
    private http: HttpClient
  ) { }

  get customer(): Customer {
    return this._customer;
  }

  getCustomerById() {
    return this.http.get<Customer>("http://localhost:8080/api/customers/1");
  }
}

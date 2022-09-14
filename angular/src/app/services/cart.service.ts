import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Cart} from "../models/cart.model";
import {BehaviorSubject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private _url: String = `http://localhost:8080/api/cart`;

  private cart: any;

  constructor(
    private http: HttpClient
  ) {

  }

  getAllCarts() {
    return this.http.get<Cart[]>(`${this._url}`);
  }

  setCart( cart: Cart ) {
    this.cart = cart;
  }

  getCart() {
    return this.cart;
  }



}

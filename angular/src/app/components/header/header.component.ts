import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CustomerService} from "../../services/customer.service";
import {CartService} from "../../services/cart.service";
import {Cart} from "../../models/cart.model";
import {Item} from "../../models/item.model";
import { ItemService } from '../../services/item.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  dropDown: boolean = false;
  dropDownCart: boolean = false;
  loggedIn: boolean;
  cart: any;
  items: Item[] =[];

  constructor(
    private router: Router,
    private customerService: CustomerService,
    private cartService: CartService,
    private itemService: ItemService
  ) {
    if (localStorage.getItem('MKPG')) {
      this.loggedIn = true;
      cartService.getAllCarts().subscribe({
        next: data => {
          const cart: any = data.find( cart => {
            return cart.customer.customerId == localStorage.getItem('MKPG');
          })
          this.cart = cart;
          this.cartService.setCart(cart);
        }

      })
    }else {
      this.loggedIn = false;
    }
  }

  ngOnInit(): void {
    this.customerService.userId$.subscribe( userId => {
      if(userId) {
        this.loggedIn = true;
      }else {
        this.loggedIn = false;
      }
    })
    this.itemService.items$.subscribe({
      next: items => {
        this.items = items
      }
    })
  }

  onMouseEnterProfile(){
    this.dropDown = true;
  }

  onMouseleaveProfile(){
    this.dropDown = false;
  }

  onMouseEnterCart() {
    this.dropDownCart = true;
  }

  onMouseleaveCart() {
    this.dropDownCart = false;
  }

  onClickLogin(){
    this.router.navigate(['/login']);
  }

  onClickRegister(){
    this.router.navigate(['/register']);
  }

  onClickProfile(){
    this.router.navigate(['/profile']);
  }

  onClickLogOut() {
    this.customerService.logout();
  }

  onClickHome() {
    this.router.navigate(['/home'])
  }

  getItemByName(event: any) {
    this.itemService.getItemByName(event)
    this.itemService.items$.subscribe({
      next: data => this.items = data
    })
  }
}

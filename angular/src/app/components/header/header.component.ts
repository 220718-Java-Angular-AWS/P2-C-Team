import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CustomerService} from "../../services/customer.service";
import {CartService} from "../../services/cart.service";
import {Cart, createCartDTO} from "../../models/cart.model";
import { ItemService } from 'src/app/services/item.service';
import { Item } from 'src/app/models/item.model';

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
          const cart: any = data.find(cart => {
            return cart.customer.customerId == localStorage.getItem('MKPG');
          })
          this.cart = cart;
          if (cart) {
            this.cartService.setCart(cart);
          } else {
            const newCart: createCartDTO = {
              total: "0",
              customer: {
                customerId: `${localStorage.getItem('MKPG')}`,
              }
            }
            this.cartService.createCart(newCart).subscribe({
              next: data => this.cartService.setCart(data)
            })
          }
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

  toCheckOut() {
    this.dropDownCart = false;
    this.router.navigate(['/checkout']);
  }
  getItemByName(event: any) {
    this.itemService.getItemByName(event)
    this.itemService.items$.subscribe({
      next: data => this.items = data
    })
  }
}

import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {CustomerService} from "../../services/customer.service";
import {CartService} from "../../services/cart.service";
import {Cart, createCartDTO} from "../../models/cart.model";
import {ItemService} from "../../services/item.service";
import {Item} from "../../models/item.model";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  router: Router
  searchItem:string = "";
  showSearch:boolean = false;
  dropDown: boolean = false;
  dropDownCart: boolean = false;
  loggedIn: boolean;
  cart: any;
  delayTimer:any;
  itemArr: Item[] | any = [];
  active = 'home';
  items: Item[] =[];


  constructor(
    private _router: Router,
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
    this.router = _router;
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

  onClickNintendo(){
    this.router.navigate(['/category/nintendo']);
  }

  onClickPlayStation(){
    this.router.navigate(['/category/playstation']);
  }

  onClickXBox(){
    this.router.navigate(['/category/xbox']);
  }

  onClickPC(){
    this.router.navigate(['/category/pc']);
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

  toggleCart() {
    if(this.dropDownCart === false) {
      this.dropDownCart = true;
    }else {
      this.dropDownCart = false;
    }
  }

  onClickShowSearch(){
    if(this.showSearch === false) {
      this.showSearch = true;
    }
  }

  hideSearch() {
    this.showSearch = false;
    this.searchItem = "";
  }

  getItems() {
    clearTimeout(this.delayTimer);
    this.delayTimer = setTimeout(  () => {
      if (this.searchItem.length > 0) {
        this.itemService.getAllItems().subscribe({
          next: data => {
            const items = data.filter(item => item.itemName.search(new RegExp(`${this.searchItem}`)) >= 0)
            this.itemArr = items;
            console.log(items)
          }
        })
      }
    }, 1500);
  }
}

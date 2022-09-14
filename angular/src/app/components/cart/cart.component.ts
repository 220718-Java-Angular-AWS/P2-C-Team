import {Component, Input, OnInit} from '@angular/core';
import {CartService} from "../../services/cart.service";
import {Cart} from "../../models/cart.model";
import {OrderService} from "../../services/order.service";
import {Order, orderOrderDTO} from "../../models/order.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  @Input() cart: Cart;
  orders: Order[] = [];

  constructor(
    private cartService: CartService,
    private orderService: OrderService,
    private router: Router,
  ) {
    this.cart = this.cartService.getCart();
    if (this.cart) {
      this.setOrder(this.cart);
    }
  }

  ngOnInit(): void {
    this.cart = this.cartService.getCart();

    this.orderService.myOrders$.subscribe({
      next: data => {
        this.orders = data;
      }
    })

    this.cartService.myCart$.subscribe({
      next: cart => {
        if (cart) {
          this.cart = cart;
          this.setOrder(cart)
        }
      }
    });
  }


  setOrder(cart:Cart) {
    this.orderService.getAllOrders().subscribe({
      next: data => {
        const orders: Order[] = data.filter( order => {

          console.log("333333333333" + cart.cartId);
          return order.cart.cartId == cart.cartId;
        })

        this.orderService.setOrders(orders);
        this.orders = orders;
      }
    })
  }

  deleteItem(id: number){
    this.orderService.deleteOrder(`${id}`).subscribe({
      next: _ => {
        this.orderService.deleteMyOrder(id);
      }
    })
  }

  addItem() {
    const order: orderOrderDTO = {
      quantity: "5",
      deliveryDate: "01-22-2022",
      status: "delivered",
      cart: {
        cartId: 4,
        total: 100,
      },
      item: {
        itemId: "19",
        itemName: "",
        price: 0,
        discountedPrice: 0,
      }
    }

    this.orderService.createOrder(order).subscribe({
      next: data => {
        this.orderService.addMyOrder(data);
      }
    });
  }

}

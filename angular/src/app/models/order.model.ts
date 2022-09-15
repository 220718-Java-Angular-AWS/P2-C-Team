import {Customer} from "./customer.model";

export interface Order {
  orderId: number,
  quantity: string,
  deliveryDate: string,
  status: string,
  cart: {
    cartId: number,
    total: number,
  },
  item: {
    itemId: string,
    itemName: string,
    price: number,
    discountedPrice: number,
  }
}

export interface orderOrderDTO extends Omit<Order, 'orderId'> {

}

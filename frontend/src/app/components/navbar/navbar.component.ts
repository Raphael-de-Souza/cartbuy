import { Component } from '@angular/core';
import { CartAction } from '../../store/actions/cart.actions';

import { AuthenticationService } from '../../services/index';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
  providers: []
})
export class NavBarComponent {

  public cart: any = [];
  public totalPrice: number;
  public totalQuantity: any;

  constructor(private cartStore: CartAction, public authService: AuthenticationService) {}

  getTotalPrice() {
    let totalCost: Array<number> = [];
    let quantity: Array<number> = [];
    let intPrice: number;
    let intQuantity: number;

    this.cart.products.forEach((item: { price: string; quantity: string; }) => {
      intPrice = parseInt(item.price);
      intQuantity = parseInt(item.quantity);
      totalCost.push(intPrice);
      quantity.push(intQuantity);
    });

    this.totalPrice = totalCost.reduce((acc, item) => {
      return acc += item;
    }, 0);
    this.totalQuantity = quantity.reduce((acc, item) => {
      return acc += item;
    }, 0);

  }
  ngOnInit() {
    this.cartStore.getState().subscribe(res => {
      this.cart = res;
      this.getTotalPrice();
    });
  }
}

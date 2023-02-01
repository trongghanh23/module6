import { Component, OnInit } from '@angular/core';
import {FashionService} from '../../service/fashion.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartCount: number;

  constructor( private fashionService: FashionService) { }

  ngOnInit(): void {
    this.getCart()
  }
  getCart(): void {
    this.fashionService.findByUsername().subscribe(customer => {
      if (customer != null) {
        this.fashionService.listCart(customer.id).subscribe(value => {
          console.log(value);
          // this.fashionService.cartCount(customer.id).subscribe(value1 => {
          //   this.cartCount = value1.cartCount;
          // });
          console.log(value);
          // this.cart = value;
          // for (const item of value) {
          //   this.totalPrice += Number(item.price) * item.quantity;
          //   this.finalPrice += Number(item.price) * item.quantity;
          // }
        });
      }
    });
  }

}

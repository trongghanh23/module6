import { Component, OnInit } from '@angular/core';
import {FashionService} from '../../service/fashion.service';
import {ListFashionDto} from "../../dto/list-fashion-dto";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cart: ListFashionDto[];
  totalPrice = 0;
  finalPrice = 0;
  cartCount: number;
  total: string;
  price: number;
  usd: number;
  action: boolean;

  constructor( private fashionService: FashionService) { }

  ngOnInit(): void {
    this.getCart();
  }
  getCart(): void {
    this.fashionService.findByUsername().subscribe(customer => {
      if (customer != null) {
        this.fashionService.listCart(customer.id).subscribe(value => {
          console.log(value);
          this.fashionService.cartCount(customer.id).subscribe(value1 => {
            this.cartCount = value1.cartCount;
          });
          console.log(value);
          this.cart = value;
          for (const item of value) {
            this.totalPrice += Number(item.price) * item.quantity;
            this.finalPrice += Number(item.price) * item.quantity;
          }
        });
      }
    });
  }
  ascQuantity(id: number): void {
    this.fashionService.ascQuantity(id).subscribe(value => {
      this.getCart();
    });
  }


  descQuantity(id: number): void {
    this.fashionService.descQuantity(id).subscribe(value => {
      this.getCart();
    });
  }

}

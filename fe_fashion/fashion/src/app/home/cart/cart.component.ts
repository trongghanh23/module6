import { Component, OnInit } from '@angular/core';
import {FashionService} from '../../service/fashion.service';
import {ListFashionDto} from '../../dto/list-fashion-dto';
import Swal from 'sweetalert2';
import {render} from 'creditcardpayments/creditCardPayments';

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
  submit(price: number) {
    if (!this.action) {
      this.action = true;
      this.usd = price / 25000;
      this.total = this.usd.toString();
      render(
        {
          id: '#myPaypal',
          value: this.total,
          currency: 'USD',
          onApprove: (details) => {
            this.payFashion();
          }
        }
      );

    } else {
      this.action = false;
    }
  }
  payFashion(): void {
    this.fashionService.findByUsername().subscribe(customer => {
      this.fashionService.payFashion(customer.id).subscribe(value => {
      });
      Swal.fire({
        position: 'center',
        icon: 'success',
        text: 'C???m ??n qu?? kh??ch !',
        title: '???? thanh to??n th??nh c??ng',
        showConfirmButton: false,
      });
      window.setTimeout(this.loadPage, 500);
    }, error => {
      Swal.fire({
        position: 'center',
        icon: 'error',
        text: 'Xin l???i qu?? kh??ch !',
        title: 'Thanh to??n th???t b???i !',
        showConfirmButton: false,
      });
    });
  }
  loadPage(): void {
    window.location.replace('/cart');
  }
  deleteCart(id: number): void {
    Swal.fire({
      title: 'B???n c?? ch???c?',
      text: 'X??a s???n ph???m n??y kh???i gi??? h??ng!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'C??, t??i mu???n x??a!',
      cancelButtonText: '????ng'
    }).then((result) => {
      if (result.isConfirmed) {
        this.fashionService.deleteCart(id).subscribe(() => {
          const Toast = Swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500,
            timerProgressBar: true,
            didOpen: (toast) => {
              toast.addEventListener('mouseenter', Swal.stopTimer);
              toast.addEventListener('mouseleave', Swal.resumeTimer);
            }
          });

          Toast.fire({
            icon: 'success',
            title: 'X??a kh???i gi??? h??ng th??nh c??ng!'
          });

          location.reload();
        }, error => {
        });
      }
    });
  }
}

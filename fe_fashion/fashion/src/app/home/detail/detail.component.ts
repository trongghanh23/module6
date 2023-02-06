import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import {BehaviorSubject} from 'rxjs';
import {ListFashionDto} from '../../dto/list-fashion-dto';
import {FashionService} from '../../service/fashion.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {TokenStorageService} from '../../service/token-storage.service';
import {ICustomer} from '../../model/iCustomer';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  id: number;
  fashion$: BehaviorSubject<ListFashionDto>;
  quantityChoose = 1;
  idUser: number;
  customer: ICustomer[];
  // employee: IEmployee[];
  fashionId: number;
  roles: string[] = [];
  isCustomer = false;
  isAdmin = false;
  // isEmployee = false;
  idCustomer: number;
  username: string;
  fashion: ListFashionDto;
  constructor(private fashionService: FashionService,
              private activatedRoute: ActivatedRoute,
              private title: Title,
              private router: Router,
              private tokenService: TokenStorageService) { }

  ngOnInit(): void {
    this.title.setTitle('chi tiết quần áo');
    const id = Number(this.activatedRoute.snapshot.params.id);
    this.fashionService.findById(id).subscribe(value => {
      this.fashionId = value.idFashion;
      this.fashion = value;
    });
    this.showUsername();
    window.scroll(0, 0);
  }
  showUsername() {
    if (this.tokenService.isLogged()) {
      this.getCustomer();
      this.username = this.tokenService.getUser().username;
      this.roles = this.tokenService.getUser().roles;
      this.isCustomer = this.roles.indexOf('ROLE_CUSTOMER') !== -1;
      this.isAdmin = this.roles.indexOf('ROLE_ADMIN') !== -1;
    }
  }
  getCustomer(): void {
    this.fashionService.findByUsername().subscribe(value => {
      this.customer = value;
      if (this.customer != null) {
        this.idUser = value.id;
      }
    });
  }
  addToCart(): void {
    if (this.idUser == null) {
      this.router.navigateByUrl('/login');
    } else {
      this.fashionService.addToCart(this.quantityChoose, this.idUser, this.fashionId).subscribe(() => {
        const Toast = Swal.mixin({
          toast: true,
          position: 'top-end',
          showConfirmButton: false,
          timer: 2000,
          timerProgressBar: true,
          didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
          }
        });

        Toast.fire({
          icon: 'success',
          title: 'Thêm vào giỏ hàng thành công!'
        });
        window.setTimeout(this.loadPage, 500);
      }, error => {
      });
    }

  }
  loadPage(): void {
    window.location.replace('/cart');
  }

}

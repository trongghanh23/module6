import { Component, OnInit } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {Title} from '@angular/platform-browser';
import Swal from 'sweetalert2';
import {TokenStorageService} from '../../service/token-storage.service';
import {FashionService} from '../../service/fashion.service';
import {IHistory} from '../../dto/i-history';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  roles: string[] = [];
  isCustomer = false;
  isAdmin = false;
  isEmployee = false;
  username = '';
  idCustomer: number;
  historyDto$: Observable<IHistory[]>;
  action: boolean;
  customerName = '';
  image = '';
  total$: Observable<number>;
  page = 1;
  pageSize = 5;

  id: number;
  price: number;
  quantity: number;
  dayBooking = '';
  status: number;
  isDelete: number;
  name = '';


  constructor(private tokenService: TokenStorageService,
              private fashionService: FashionService,
              private title: Title) {
    title.setTitle('Lịch sủ');
  }

  ngOnInit(): void {
    this.showUsername();
    this.getAllHistory();
    this.getAllCustomer();
    window.scroll(0, 0);

  }

  showUsername() {
    if (this.tokenService.isLogged()) {
      this.username = this.tokenService.getUser().username;
      this.roles = this.tokenService.getUser().roles;
      this.isCustomer = this.roles.indexOf('ROLE_CUSTOMER') !== -1;
      this.isEmployee = this.roles.indexOf('ROLE_EMPLOYEE') !== -1;
      this.isAdmin = this.roles.indexOf('ROLE_ADMIN') !== -1;
    }
  }

  getAllHistory() {
    this.fashionService.getAllHistory(this.page, this.pageSize, this.username).subscribe(value => {
      console.log(value);
      if (value != null) {
        this.action = true;
        this.historyDto$ = new BehaviorSubject<IHistory[]>(value.content);
        this.total$ = new BehaviorSubject<number>(value.totalElements);
      } else {
        console.log('a');
        this.action = false;
      }
    });
  }

  getAllCustomer() {
    this.fashionService.findAllCustomer(this.username).subscribe(value => {
      this.customerName = value.name;
      this.image = value.image;
    });
  }

}

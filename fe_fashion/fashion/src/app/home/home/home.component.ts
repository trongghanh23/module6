import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {ListFashion} from "../../dto/list-fashion";
import {HomeService} from "../../service/home.service";
import {TokenStorageService} from "../../service/token-storage.service";
import {FashionService} from "../../service/fashion.service";
import {Title} from "@angular/platform-browser";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username: string;
  roles: string[] = [];
  isCustomer = false;
  isAdmin = false;
  pageSize = 8;
  fashionList$: Observable<ListFashion[]> | undefined;
  total$: Observable<number>;
  fashionNameSearch = '';
  action: boolean;

  content: boolean;

  id: number;
  constructor(
    private homeService: HomeService,
    private tokenService: TokenStorageService,
    private fashionService: FashionService,
    private title: Title,
    private router: Router) {
    this.title.setTitle('Trang chủ');
  }
  ngOnInit(): void {
    this.showUsername();
    this.paginate(this.fashionNameSearch, this.pageSize);
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });

  }
  showUsername() {
    this.username = this.tokenService.getUser().username;
    this.roles = this.tokenService.getUser().roles;
    this.isCustomer = this.roles.indexOf('ROLE_CUSTOMER') !== -1;
    this.isAdmin = this.roles.indexOf('ROLE_ADMIN') !== -1;
  }

  paginate(fashionNameSearch, pageSize) {
    this.fashionService.findAllListFashion(fashionNameSearch, pageSize).subscribe(data => {
      if (data != null) {
        this.action = true;
        this.fashionList$ = new BehaviorSubject<ListFashion[]>(data.content);
        console.log(this.fashionList$);
        this.total$ = new BehaviorSubject<number>(data.totalElements);
      } else {
        this.action = false;
      }
    });
  }

  nextPage() {
    this.pageSize += 4;
    this.paginate(this.fashionNameSearch, this.pageSize);
  }

}

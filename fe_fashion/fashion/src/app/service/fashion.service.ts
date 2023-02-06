import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {TokenStorageService} from './token-storage.service';
import {Observable} from 'rxjs';
import {SearchResult} from '../model/search-result';
import {ListFashionDto} from '../dto/list-fashion-dto';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FashionService {
  URL_API = `${environment.api_url}`;
  httpOptions: any;

  constructor(private httpClient: HttpClient, private tokenService: TokenStorageService) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.tokenService.getToken()
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }
  findByUsername(): Observable<any> {
    return this.httpClient.get<any>(this.URL_API + '/fashion/get/customer/', this.httpOptions);
  }

  findAllListFashion(name: string, size: number): Observable<SearchResult<ListFashionDto>> {
    const API_URL_HOME = this.URL_API + '/fashion/list/home?size=' + size + '&name=' + name;
    return this.httpClient.get<SearchResult<ListFashionDto>>(API_URL_HOME);
  }

  listCart(id: number): Observable<ListFashionDto[]> {
    return this.httpClient.get<ListFashionDto[]>(this.URL_API + '/booking/list/cart/' + id);
  }

  cartCount(id: number): Observable<any> {
    return this.httpClient.get<any>(this.URL_API + '/booking/cart/count/' + id);
  }

  ascQuantity(id: number): Observable<void> {
    return this.httpClient.get<void>(this.URL_API + '/booking/asc/quantity/' + id);
  }

  descQuantity(id: number): Observable<void> {
    return this.httpClient.get<void>(this.URL_API + '/booking/desc/quantity/' + id);
  }
  addToCart(quantity: number, customerId: number, fashionId: number): Observable<void> {
    return this.httpClient.get<void>(this.URL_API + '/booking/add/cart/' + quantity + '&' + customerId + '&' + fashionId);
  }
  findById(id: number): Observable<ListFashionDto> {
    return this.httpClient.get<ListFashionDto>(this.URL_API + '/fashion/detail/' + id);
  }
  payFashion(id: number): Observable<void> {
    return this.httpClient.get<void>(this.URL_API + '/booking/pay/fashion/' + id);
  }
}

import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {TokenStorageService} from "./token-storage.service";
import {Observable} from "rxjs";
import {SearchResult} from "../model/search-result";
import {ListFashion} from "../dto/list-fashion";

@Injectable({
  providedIn: 'root'
})
export class FashionService {
  URL_API = '${environment.api_url}';
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

  findAllListFashion(name: string, size: number): Observable<SearchResult<ListFashion>> {
    console.log(this.URL_API + '/fashion/list/home?name=' + name + '&size=' + size);
    const API_URL_HOME = this.URL_API + '/fashion/list/home?name=' + name + '&size=' + size;
    return this.httpClient.get<SearchResult<ListFashion>>(API_URL_HOME);
  }
}

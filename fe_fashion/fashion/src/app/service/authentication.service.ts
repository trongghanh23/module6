import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {JwtResponseService} from './jwt-response-service';
import {IUser} from '../model/i-user';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  loginUrl = 'http://localhost:8080/api/public';
  constructor(private http: HttpClient) { }

}

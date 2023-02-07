import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import {HomeComponent} from './home/home.component';
import { LoginComponent } from '../decentralization/login/login.component';
import { CartComponent } from './cart/cart.component';
import { DetailComponent } from './detail/detail.component';
import {FormsModule} from '@angular/forms';
import {HistoryComponent} from './history/history.component';
import {NgbPaginationModule} from "@ng-bootstrap/ng-bootstrap";


@NgModule({
  declarations: [
  HomeComponent,
  CartComponent,
    HistoryComponent,
  DetailComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    NgbPaginationModule
  ]
})
export class HomeModule { }

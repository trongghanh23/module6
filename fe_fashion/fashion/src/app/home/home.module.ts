import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import {HomeComponent} from './home/home.component';
import { LoginComponent } from '../decentralization/login/login.component';
import { CartComponent } from './cart/cart.component';
import { DetailComponent } from './detail/detail.component';


@NgModule({
  declarations: [
  HomeComponent,
  CartComponent,
  DetailComponent],
  imports: [
    CommonModule,
    HomeRoutingModule
  ]
})
export class HomeModule { }

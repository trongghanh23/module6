import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { FooterComponent } from './footer/footer.component';
import {HomeComponent} from './home/home.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './cart/cart.component';
import { DetailComponent } from './detail/detail.component';


@NgModule({
  declarations: [
  HomeComponent,
  LoginComponent,
  CartComponent,
  DetailComponent],
  imports: [
    CommonModule,
    HomeRoutingModule
  ]
})
export class HomeModule { }

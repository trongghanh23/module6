import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DecentralizationRoutingModule } from './decentralization-routing.module';
import {LoginComponent} from './login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {FocusInvalidInputDirective} from './util/focus-invalid-input.directive';



@NgModule({
  declarations: [LoginComponent, FocusInvalidInputDirective],
  exports: [
    LoginComponent,
  ],
  imports: [
    CommonModule,
    DecentralizationRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
  ]
})
export class DecentralizationModule { }

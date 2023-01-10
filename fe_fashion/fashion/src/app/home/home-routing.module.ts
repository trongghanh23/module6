import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {CartComponent} from './cart/cart.component';
import {DetailComponent} from './detail/detail.component';


const routes: Routes = [
  {
    path: '', component: HomeComponent
  }, {
    path: 'login', component: LoginComponent
  } , {
    path: 'cart', component: CartComponent
  }, {
    path: 'detail', component: DetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}

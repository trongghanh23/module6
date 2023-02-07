import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {CartComponent} from './cart/cart.component';
import {DetailComponent} from './detail/detail.component';
import {LoginComponent} from '../decentralization/login/login.component';
import {AuthGuard} from '../decentralization/auth.guard';
import {HistoryComponent} from './history/history.component';



const routes: Routes = [
  {
    path: '', component: HomeComponent
  }, {
    path: 'login', component: LoginComponent
  },
  {
    path: 'history', component: HistoryComponent
  },
  {
    path: 'cart', canActivate: [AuthGuard],
    data: {
      roles: ['ROLE_CUSTOMER']
    },
    component: CartComponent
  }, {
    path: 'detail/:id', component: DetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}

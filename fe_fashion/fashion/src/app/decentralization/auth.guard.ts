import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import {Observable} from 'rxjs';
import {TokenStorageService} from '../service/token-storage.service';
import Swal from "sweetalert2";


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private router: Router,
              private tokenStorageService: TokenStorageService) {
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    const url: string = state.url;
    const currentUser = this.tokenStorageService.getUser();
    if (currentUser !== null) {
      const role = currentUser.roles;
      if (role.indexOf(route.data.roles[0]) === -1) {
        Swal.fire({
          position: 'center',
          icon: 'warning',
          title: 'Người dùng không được phép truy cập!',
          showConfirmButton: false,
          timer: 2000
        });
        return false;
      }
      return true;
    }
    this.router.navigate(['login'], {queryParams: {returnUrl: state.url}});
    return false;

  }
}

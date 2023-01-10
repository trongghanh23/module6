import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import Swal from 'sweetalert2';
import {Title} from '@angular/platform-browser';
import {AuthenticationService} from '../../service/authentication.service';
import {TokenStorageService} from '../../service/token-storage.service';
import {AuthService} from '../../service/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  formGroup: FormGroup;
  username: string;
  roles: string[] = [];
  returnUrl: string;


  constructor(
    private auth: AuthenticationService,
    private ref: ChangeDetectorRef,
    private formBuild: FormBuilder,
    private tokenStorageService: TokenStorageService,
    private authService: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private title: Title) {
    title.setTitle('Đăng nhập');
    this.formGroup = this.formBuild.group({
        username: [''],
        password: [''],
        rememberMe: ['']
      }
    );
  }

  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams.returnUrl || '';
    this.formGroup = this.formBuild.group({
        username: ['', Validators.required],
        password: ['', Validators.required],
        remember_me: ['']
      }
    );

    if (this.tokenStorageService.getToken()) {
      const user = this.tokenStorageService.getUser();
      this.authService.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
      this.username = this.tokenStorageService.getUser().username;
    }
  }

  onSubmit() {
    this.authService.login(this.formGroup.value).subscribe(
      data => {
        if (this.formGroup.value.remember_me) {
          this.tokenStorageService.saveTokenLocal(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        } else {
          this.tokenStorageService.saveTokenSession(data.accessToken);
          this.tokenStorageService.saveUserLocal(data);
        }

        this.authService.isLoggedIn = true;
        this.username = this.tokenStorageService.getUser().username;
        this.roles = this.tokenStorageService.getUser().roles;
        this.formGroup.reset();

        Swal.fire({
          position: 'center',
          icon: 'success',
          title: this.username + ' Đăng nhập thành công !',
          showConfirmButton: false,
          timer: 2000
        });
        window.location.replace('');
      },
      err => {
        this.authService.isLoggedIn = false;
        Swal.fire({
          position: 'center',
          icon: 'warning',
          title: 'Người dùng/ mật khẩu không hợp lệ. Vui lòng thử lại!',
          showConfirmButton: false,
          timer: 2000
        });
      }
    );
  }

  logOut(): void {
    this.tokenStorageService.logOut();
    window.location.reload();
  }

// whenExit() {
//   this.tokenStorageService.signOut();
//   this.username = '';
//   this.router.navigateByUrl('');
// }
}

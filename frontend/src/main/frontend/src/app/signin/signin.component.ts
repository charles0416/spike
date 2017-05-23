import { Component, Input } from '@angular/core';
import { User } from '../_models/user';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../_services/user.service';

@Component({
  selector: 'signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.css']
})
export class SigninComponent {
  @Input() user: User;
  @Input() rememberUser: boolean;
  alertMessage: string;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private userService: UserService
  ) {
    if (window.localStorage.getItem("CURRENT_USER") != null) {
      this.user = JSON.parse(window.localStorage.getItem("CURRENT_USER"));
    } else {
      this.user = new User();
    }

    if (window.localStorage.getItem("REMEMBER_USER") != null) {
      this.rememberUser = window.localStorage.getItem("REMEMBER_USER") == 'TRUE';
    } else {
      this.rememberUser = false;
    }
  }

  onSubmit(): void {
    //TODO: verify inputs
    window.localStorage.removeItem('CURRENT_USER');
    window.localStorage.removeItem('REMEMBER_USER');
    if (this.rememberUser) {
      window.localStorage.setItem("REMEMBER_USER", "TRUE");
    }

    let u = this.userService.signIn(this.user.email, this.user.password);
    if (u == null) {
      this.alertMessage = 'Signin error, please try again';
    } else {
      this.user = u;
      window.localStorage.setItem('CURRENT_USER', JSON.stringify(this.user));
      this.router.navigate(['/home']);
    }
  }
}

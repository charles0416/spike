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
  }

  signInUser(): void {
    //TODO: verify inputs
    console.log('login email = ' + this.user.email);
    window.localStorage.removeItem('CURRENT_USER');
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

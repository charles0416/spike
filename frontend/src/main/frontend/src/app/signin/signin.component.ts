import { Component, Input } from '@angular/core';
import { User } from '../_models/user';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'signin',
  templateUrl: './signin.component.html'
})
export class SigninComponent {
  @Input() user: User;

  constructor(private route: ActivatedRoute,
    private router: Router,
  ) {
    this.user = new User();
    this.user.email = "cshi@adaptive";
  }

  signin() {
    this.router.navigate(['/home']);
  }

}

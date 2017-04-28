import { Component, Input } from '@angular/core';

import { User } from './user';

@Component({
  selector: 'signin',
  templateUrl: './signin.component.html'
})
export class SigninComponent {
  @Input() user: User;

  constructor(){
    this.user = new User();
    this.user.email = "cshi@adaptive";
  }
}

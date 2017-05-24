import { Component, Input } from '@angular/core';
import { User } from '../_models/user';

@Component({
    selector: 'register',
    templateUrl: './register.component.html'
})
export class RegisterComponent {
    @Input() user: User;
    repeatPassword: String = "";

    constructor() {
        this.user = new User();
    }

    onSubmit(): void {

    }
}

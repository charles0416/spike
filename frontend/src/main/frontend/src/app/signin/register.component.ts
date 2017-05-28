import { Component, Input } from '@angular/core';
import { User } from '../_models/user';
import { UserService } from '../_services/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'register',
    templateUrl: './register.component.html'
})
export class RegisterComponent {
    @Input() user: User;
    repeatPassword: String = "";
    loading: boolean = false;
    alertMessage: String = null;


    constructor(private route: ActivatedRoute,
        private router: Router,
        private userService: UserService
    ) {
        this.user = new User();
    }

    onSubmit(): void {
        this.loading = true;
        this.userService.create(this.user).subscribe(
            data => {
                localStorage.setItem('CURRENT_USER', JSON.stringify(data));
                this.router.navigate(['/signin']);
                this.loading = false;
            },
            error => {
                // this.alertService.error(error);
                this.alertMessage = 'Register error, please try again';
                this.loading = false;
            }, 
            () => { });
    }
}

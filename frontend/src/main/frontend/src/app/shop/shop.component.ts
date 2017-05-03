import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
    selector: 'shop',
    templateUrl: './shop.component.html'
})
export class ShopComponent {
    constructor(private route: ActivatedRoute,
        private router: Router) { }
    createShop() {
        //console.log("Create shop event triggered.");
    }

    cancelClicked(event) {
        this.router.navigate(['/home']);
    }
}
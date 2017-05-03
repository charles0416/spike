import { Component, Input } from '@angular/core';

import { User } from '../_models/user';
import { Shop } from '../_models/shop'
@Component({
  selector: 'home',
  templateUrl: './home.component.html'
})
export class HomeComponent {
  currentUser : User;
  currentShop : Shop;
  shops: Shop[] = [];
  constructor() {
    this.currentUser = new User();
    this.currentUser.fullName = "Lisa Guo";
    let tempShop = new Shop();
    tempShop.id = 1;
    tempShop.name = 'Lisa\'s little shop';
    this.shops[0] = tempShop;
    this.shops[1] = new Shop();
    this.shops[1].id = 2;
    this.shops[1].name = 'Shop 2';
    this.currentShop = this.shops[0];
  }
}

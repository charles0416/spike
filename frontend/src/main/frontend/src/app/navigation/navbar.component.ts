import { Component, Input } from '@angular/core';
import { Shop } from '../_models/shop';
import { User } from '../_models/user';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html'
})
export class NavigationBarComponent {
  showSearchBox: boolean = false;
  @Input() currentUser: User;
  @Input() currentShop: Shop;
  @Input() shops: Shop[];
  constructor() {
  }
}

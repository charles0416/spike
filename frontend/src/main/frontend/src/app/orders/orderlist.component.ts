import { Component, Input } from '@angular/core';

import { Order } from '../_models/order';

@Component({
    selector: 'orderlist',
    templateUrl: './orderlist.component.html'
})
export class OrderListComponent {
    orders: Order[];
    constructor() {
        this.orders = [];
        for (var i = 0; i < 5; i++) {
            this.orders[i] = new Order();
            this.orders[i].amount = i * 100 + i;
        }
    }
}

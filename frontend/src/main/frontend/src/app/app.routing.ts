import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { SigninComponent } from './signin/signin.component';
import { RegisterComponent } from './signin/register.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { OrdersComponent } from './orders/orders.component';
import { CustomersComponent } from './customers/customers.component';
import { ShopComponent } from './shop/shop.component';
import { HelpComponent } from './help/help.component';
import { SettingsComponent } from './settings/settings.component';
import { AuthGuard } from './_guards/auth.guard';

const appRoutes: Routes = [
    { path: '', component: SigninComponent, canActivate: [AuthGuard] },
    { path: 'signin', component: SigninComponent },
    { path: 'help', component: HelpComponent },
    { path: 'signin', component: SigninComponent },
    { path: 'signout', component: SigninComponent },
    { path: 'register', component: RegisterComponent },
    {
        path: 'home',
        component: HomeComponent,
        children: [
            { path: 'dashboard', component: DashboardComponent, outlet: 'main', pathMatch: 'full' },
            { path: 'orderlist', component: OrdersComponent, outlet: 'main', pathMatch: 'full' },
            { path: 'customers', component: CustomersComponent, outlet: 'main', pathMatch: 'full' },
            { path: 'settings', component: SettingsComponent, outlet: 'main', pathMatch: 'full' },
            { path: 'shop', component:ShopComponent, outlet: 'main', pathMatch: 'full' }
        ]
    },
    // otherwise redirect to home
    { path: '**', redirectTo: 'signin' }
];

export const routing = RouterModule.forRoot(appRoutes);
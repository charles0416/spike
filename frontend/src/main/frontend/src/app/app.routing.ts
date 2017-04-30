import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { SigninComponent } from './signin/signin.component';
import { RegisterComponent } from './signin/register.component';
import { AuthGuard } from './_guards/auth.guard';

const appRoutes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'signin', component: SigninComponent },
    { path: 'signout', component: SigninComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'home', component: HomeComponent },

    // otherwise redirect to home
    { path: '**', redirectTo: 'signin' }
];

export const routing = RouterModule.forRoot(appRoutes);
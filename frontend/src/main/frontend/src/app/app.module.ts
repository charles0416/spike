import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MockBackend, MockConnection } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';

import { AppComponent } from './app.component';
import { routing } from './app.routing';
import { AuthGuard } from './_guards/index';
import { SigninComponent, RegisterComponent } from './signin/index';
import { HomeComponent } from './home/index';
import { NavigationBarComponent } from './navigation/index';
import { OrdersComponent } from './orders/index';
import { ShopComponent } from './shop/index';
import { DashboardComponent } from './dashboard/index';
import { CustomersComponent } from './customers/index';
import { SettingsComponent } from './settings/index';
import { HelpComponent } from './help/index';
import { UserService } from './_services/index';
import { fakeBackendProvider } from './_helpers/index';


@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    HomeComponent,
    RegisterComponent,
    NavigationBarComponent,
    OrdersComponent,
    ShopComponent,
    DashboardComponent,
    CustomersComponent,
    SettingsComponent,
    HelpComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [
    AuthGuard,
    UserService,
    fakeBackendProvider,
    MockBackend,
    BaseRequestOptions
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

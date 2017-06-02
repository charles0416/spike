import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { FormControl, ReactiveFormsModule, NgForm, NgModel } from '@angular/forms';
import { RouterModule, Routes, Router } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { SigninComponent } from './signin.component';
import { RegisterComponent } from './register.component';
import { UserService } from '../_services/user.service';

describe('SigninComponent', () => {
    let comp: SigninComponent;
    let fixture: ComponentFixture<SigninComponent>;
    let de: DebugElement;
    let el: HTMLElement;


    beforeEach(async(() => {
        TestBed.configureTestingModule({
            imports: [
                ReactiveFormsModule,
                RouterModule,
                RouterTestingModule.withRoutes([
                    { path: 'register', component: RegisterComponent }
                ])],
            declarations: [
                SigninComponent,
                RegisterComponent,
                NgForm,
                NgModel
            ],
            providers: [
                { provide: UserService, useClass: UserServiceStud }
            ]
        }).compileComponents();
    }
    ));

    beforeEach(() => {
        fixture = TestBed.createComponent(SigninComponent);
        comp = fixture.componentInstance;
    });

    it('Should create', async(
        () => {
            expect(comp).toBeTruthy();
        }
    ));

    it('Should forward to register when register link clicked', async(() => {
        fail('Not implemented yet.');

    }));

    it('Should login', async(() => {
        fail('Not implemented yet.');

    }));

    it('Should show error message', async(() => {
        fail('Not implemented yet.');
    }));

    it('Should disable the signin button if username or password is empty.', async(() => {
        fail('Not implemented yet.');
    }));

    it('Should show copyright', async(() => {
        fail('Not implemented yet.');
    }));
});

class UserServiceStud {

}
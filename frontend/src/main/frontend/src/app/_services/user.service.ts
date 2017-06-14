import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'

import { User } from '../_models/index';

@Injectable()
export class UserService {
    constructor(private http: Http) {

    }

    create(user: User) {
        return this.http.post('/api/users', JSON.stringify(user)).map((response: Response) => response.json());
    };

    signIn(email: string, password: string) {
        return this.http.post('/api/authenticate', JSON.stringify({ email: email, password: password }))
            .map((response: Response) => {
                // login successful if there's a jwt token in the response
                let user = response.json();
                if (user && user.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('CURRENT_USER', JSON.stringify(user));
                }
            });
    }

    signOut(): void {
        localStorage.removeItem('CURRENT_USER');
    }
}
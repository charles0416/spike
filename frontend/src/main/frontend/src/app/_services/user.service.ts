import { Injectable } from '@angular/core';
import { User } from '../_models/user';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map'

@Injectable()
export class UserService {
    constructor(private http: Http) {

    }

    registerUser(user: User): User {
        return null;
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

    signOut(username: string): void {
        localStorage.removeItem('CURRENT_USER');
    }
}
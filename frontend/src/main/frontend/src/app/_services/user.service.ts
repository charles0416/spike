import { Injectable } from '@angular/core';
import { User } from '../_models/user'

@Injectable()
export class UserService {
    registerUser(user: User): User {
        return null;
    };

    signIn(userOrEmail: string, password: string): User {
        let user: User = new User(); 
        user.email = userOrEmail;
        user.password = password;
        return user;
    }

    signOut(username: string): void {

    }
}
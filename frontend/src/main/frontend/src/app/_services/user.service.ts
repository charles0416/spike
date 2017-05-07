import { Injectable } from '@angular/core';
import { User } from '../_models/User'

@Injectable()
export class UserService {
    registerUser(user: User): User {
        return null;
    };

    signIn(userOrEmail: string, password: string): User {
        return null;
    }

    signOut(username: string): void {

    }
}
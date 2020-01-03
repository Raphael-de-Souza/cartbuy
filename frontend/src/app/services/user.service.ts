import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

import { User } from '../models/index';
import { AppConstant as APP_CONST } from '../constants/index';

@Injectable()
export class UserService {


    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get(APP_CONST.BASE_PATH + '/api/users', this.jwt());
    }

    getById(id: number) {
        return this.http.get(APP_CONST.BASE_PATH + '/api/users/' + id, this.jwt());
    }

    create(user: User) {
        return this.http.post(APP_CONST.BASE_PATH + '/api/users', user, this.jwt());
    }

    update(user: User) {
        return this.http.put(APP_CONST.BASE_PATH + '/api/users/' + user.id, user, this.jwt());
    }

    delete(id: number) {
        return this.http.delete(APP_CONST.BASE_PATH + '/api/users/' + id, this.jwt());
    }

    // private helper methods

    private jwt() {
        // create authorization header with jwt token
        const currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (currentUser && currentUser.token) {
            return null; //new HttpHeaders({Authorization : 'Bearer ' + currentUser.token});
        }
    }
}

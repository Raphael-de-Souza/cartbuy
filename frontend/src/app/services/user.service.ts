import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { User } from '../models/index';
import { AppConstant as APP_CONST } from '../constants/index';

@Injectable()
export class UserService {

    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get(APP_CONST.BASE_PATH + '/api/users', this.jwt()).pipe(map(response => response));
    }

    getById(id: number) {
        return this.http.get(APP_CONST.BASE_PATH + '/api/users/' + id, this.jwt()).pipe(map(response => response));
    }

    create(user: User) {
        return this.http.post(APP_CONST.BASE_PATH + '/api/users', user, this.jwt()).pipe(map(response => response));
    }

    update(user: User) {
        return this.http.put(APP_CONST.BASE_PATH + '/api/users/' + user.id, user, this.jwt()).pipe(map(response => response));
    }

    delete(id: number) {
        return this.http.delete(APP_CONST.BASE_PATH + '/api/users/' + id, this.jwt()).pipe(map(response => response));
    }

    // private helper methods

    private jwt() {
        // create authorization header with jwt token
        const currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (currentUser && currentUser.token) {
            let requestHeaders: HttpHeaders;
            requestHeaders = new HttpHeaders().append('Content-Type', 'application/json');
            return {headers: requestHeaders};
        }
    }
}

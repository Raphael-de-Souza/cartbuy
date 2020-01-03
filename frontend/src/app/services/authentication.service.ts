import { Injectable } from '@angular/core';

import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthenticationService {
    private requestHeaders: HttpHeaders;

    constructor(private http: HttpClient, private router: Router) {
        this.requestHeaders = new HttpHeaders();
        this.requestHeaders.append('Content-Type', 'application/json');
        this.requestHeaders.append('Accept', 'application/json');
    }

    login(username: string, password: string) {
        return this.http.post('http://localhost:9010/sc/api/v1/login',
         JSON.stringify({ username: username, password: password }),this.jwt());
    }

    logout() {
        // remove user from local storage to log user out

         this.http.post('http://localhost:9010/sc/api/v1/logout',{},
          this.jwt()).subscribe(() =>
            {
                localStorage.removeItem('currentUser');
                this.router.navigate(['/login'], { queryParams: { returnUrl: 'home/product' }});
            });

    }

    private jwt() {
        // create authorization header with jwt token
        const currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (currentUser && currentUser.token) {
            this.requestHeaders.append('Authorization' , 'Bearer ' + currentUser.token);
            return null; //this.http.post('http://localhost:9010/sc/api/v1',{}, this.requestHeaders);
        }
    }
}

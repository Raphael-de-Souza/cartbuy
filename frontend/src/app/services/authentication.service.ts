import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AuthenticationService {
    constructor(private http: HttpClient, private router: Router) { }

    login(username: string, password: string) {
        return this.http.post('http://localhost:8080/api/login',
         JSON.stringify({ username , password }), this.jwt())
            .pipe(map(response => {
                // login successful if there's a jwt token in the response
                if ( response) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(response));
                }

                return response;
            }));
    }

    logout() {
        // remove user from local storage to log user out

         this.http.post('http://localhost:8080/api/logout', {},
          this.jwt()).subscribe(() => {
                localStorage.removeItem('currentUser');
                this.router.navigate(['/login'], { queryParams: { returnUrl: 'home/product' }});
           });
    }

    private jwt() {
        // create authorization header with jwt token

            let requestHeaders: HttpHeaders;
            requestHeaders = new HttpHeaders().append('Content-Type', 'application/json');
            return {headers: requestHeaders};
    }
}

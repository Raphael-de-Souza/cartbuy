import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

// The consumer of angular services doesn't know how the service gets the data.
// This ProductService could get the data from anywhere.
// It could get the data from a web service or local storage or from a mock data source.
// That's the beauty of removing data access from the component.
// We can change our minds about the implementation as often as we like, for whatever reason,
// without touching any of the components that need the data.
@Injectable()
export class ProductService {

    constructor(private http: HttpClient) { }


    getProducts() {
        return this.http.get('http://localhost:8080/api/products', this.jwt());
    }

    getProduct(id: string | number) {
       return this.http.get('http://localhost:8080/api/product/' + id, this.jwt());
    }

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

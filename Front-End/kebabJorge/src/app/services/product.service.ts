import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getAllProducts(): Observable<any> {
    return this.http.get(`${this.apiUrl}/productos`);
  }

  getProductById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/productos/${id}`);
  }

  createProduct(productData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/productos`, productData);
  }

  updateProduct(id: number, productData: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/productos/${id}`, productData);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/productos/${id}`);
  }
}

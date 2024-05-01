import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {

  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  getAllProviders(): Observable<any> {
    return this.http.get(`${this.apiUrl}/proveedores`);
  }
}

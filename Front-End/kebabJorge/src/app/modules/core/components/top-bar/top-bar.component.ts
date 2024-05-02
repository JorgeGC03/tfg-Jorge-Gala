import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { Router, RouterModule } from '@angular/router';
import { ProductosComponent } from '../../../../pages/productos/productos.component';
import { Product } from '../../../../models/product';



@Component({
  selector: 'app-top-bar',
  standalone: true,
  imports: [CommonModule, HttpClientModule, MatIconModule, MatMenuModule, RouterModule, ProductosComponent],
  templateUrl: './top-bar.component.html',
})
export class TopBarComponent {

  productos: Product[] = [];  

  constructor(private router: Router) { }

  filtrarProductos(tipo: number) {
    this.router.navigate(['/productos'], { queryParams: { tipo: tipo } });
  }

}

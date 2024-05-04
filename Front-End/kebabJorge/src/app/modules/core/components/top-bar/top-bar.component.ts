import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { ProductosComponent } from '../../../../pages/productos/productos.component';
import { Product } from '../../../../models/product';



@Component({
  selector: 'app-top-bar',
  standalone: true,
  imports: [ ProductosComponent, RouterLink],
  templateUrl: './top-bar.component.html',
})
export class TopBarComponent {

  productos: Product[] = [];  

  constructor(private router: Router) { }

  filtrarProductos(tipo: number) {
    this.router.navigate(['/productos'], { queryParams: { tipo: tipo } });
  }

}

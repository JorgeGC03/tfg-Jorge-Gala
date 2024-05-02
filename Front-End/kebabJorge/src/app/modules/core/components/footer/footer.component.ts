import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { RouterModule } from '@angular/router';
import { ProductosComponent } from '../../../../pages/productos/productos.component';
import { CarritoComponent } from '../../../../pages/carrito/carrito.component';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule, HttpClientModule,  MatMenuModule, RouterModule, CarritoComponent],
  templateUrl: './footer.component.html',
})
export class FooterComponent {

}

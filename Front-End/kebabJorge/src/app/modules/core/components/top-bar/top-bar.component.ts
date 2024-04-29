import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { Router, RouterModule } from '@angular/router';
import { ProductosComponent } from '../../../../pages/productos/productos.component';
import { ProductService } from '../../../../services/product.service';



@Component({
  selector: 'app-top-bar',
  standalone: true,
  imports: [CommonModule, HttpClientModule, MatIconModule, MatMenuModule, RouterModule, ProductosComponent],
  templateUrl: './top-bar.component.html',
  styleUrl: './top-bar.component.scss'
})
export class TopBarComponent {

  constructor(private router: Router, private productService: ProductService) { }



}

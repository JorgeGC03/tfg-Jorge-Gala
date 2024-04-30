import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [RouterOutlet, CommonModule, HttpClientModule ],
  templateUrl: './productos.component.html',
  styleUrl: './productos.component.scss'
})
export class ProductosComponent implements OnInit{
  productos: Product[] = [];
  tipoProducto!: number;

  constructor(private productService: ProductService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.tipoProducto = params['tipo'];
      if (this.tipoProducto) {
        this.getProductosPorTipo(this.tipoProducto);
      } else {
        this.getAllProducts();
      }
    });
  }

  getAllProducts() {
    this.productService.getAllProducts().subscribe(response => {
      this.productos = response.data;
    });
  }

  getProductosPorTipo(tipo: number) {
    this.productService.getProductosPorTipo(tipo).subscribe(response => {
      this.productos = response.data;
    });
  }

}

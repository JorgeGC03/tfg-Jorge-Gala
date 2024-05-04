import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterOutlet } from '@angular/router';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './productos.component.html',
})
export class ProductosComponent implements OnInit{
  productos: Product[] = [];
  tipoProducto!: number;

  constructor(private productService: ProductService, private route: ActivatedRoute, private router: Router) { }

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

  verDetalleProducto(id: number) {
    this.router.navigate(['/productos', id]);
    console.log('Ver detalle del producto con ID:', id);

  }

}

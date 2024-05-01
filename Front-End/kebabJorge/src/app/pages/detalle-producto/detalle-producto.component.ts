import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { ActivatedRoute, Router, RouterOutlet } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ProductosComponent } from '../productos/productos.component';
import { delay, timeout } from 'rxjs';

@Component({
  selector: 'app-detalle-producto',
  standalone: true,
  imports: [RouterOutlet, CommonModule, HttpClientModule, ProductosComponent],
  templateUrl: './detalle-producto.component.html',
  styleUrl: './detalle-producto.component.scss'
})
export class DetalleProductoComponent implements OnInit {

  producto: Product | undefined;

  constructor(private route: ActivatedRoute, private productService: ProductService, private router: Router) { }

  ngOnInit(): void {
    this.getDetalleProducto();
    console.log('Detalle del producto:', this.producto);
  }

  getDetalleProducto(): void {
    const idString = this.route.snapshot.paramMap.get('id');
    if (idString) {
      const id = +idString;
      if (!isNaN(id)) {
        this.productService.getProductById(id)
          .subscribe(
            (response: any) => {
              // Mapear los nombres de los ingredientes
              const ingredientes = response.data.ingredientes.map((ingrediente: any) => ingrediente.nombreIngrediente);

              // Crear un nuevo objeto Product con los datos del producto y los nombres de los ingredientes
              this.producto = {
                productoId: response.data.productoId,
                nombre: response.data.nombre,
                descripcion: response.data.descripcion,
                precio: response.data.precio,
                tipo: response.data.tipo,
                imageUrl: response.data.imageUrl,
                ingredientes: ingredientes,
                quantity: response.data.quantity || 1
              };

              console.log('Datos del producto:', this.producto);
            },
            error => console.error('Error al obtener el detalle del producto:', error)
          );
      } else {
        console.error('El ID no es un número válido.');
      }
    } else {
      console.error('No se encontró ningún ID en la URL.');
    }
  }

  addToCart(): void {
    if (this.producto) {
      let cartItems: Product[] = JSON.parse(localStorage.getItem('cartItems') || '[]');
      cartItems.push(this.producto);
      localStorage.setItem('cartItems', JSON.stringify(cartItems));
      this.router.navigate(['/productos']); // Redirige al componente del carrito
    }
  }
}


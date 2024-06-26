import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { ActivatedRoute, Router, RouterOutlet } from '@angular/router';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-detalle-producto',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './detalle-producto.component.html',
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
              const ingredientes = response.data.ingredientes.map((ingrediente: any) => ingrediente.nombreIngrediente);
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
      this.router.navigate(['/productos']);
    }
  }
}


import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { RouterOutlet } from '@angular/router';
import { ProductosComponent } from '../productos/productos.component';
import { DetalleProductoComponent } from '../detalle-producto/detalle-producto.component';

@Component({
  selector: 'app-carrito',
  standalone: true,
  imports: [RouterOutlet, CommonModule, HttpClientModule, ProductosComponent, DetalleProductoComponent, CarritoComponent],
  templateUrl: './carrito.component.html',
  styleUrl: './carrito.component.scss'
})
export class CarritoComponent implements OnInit {
  cartItems: Product[] = [];
  totalPrice: number = 0;

  constructor() { }

  ngOnInit(): void {
    this.loadCartItems();
    this.calculateTotalPrice(); // Calcular el precio total inicial
  }

  loadCartItems() {
    if (typeof localStorage !== 'undefined') {
      const storedItems = localStorage.getItem('cartItems');
      if (storedItems) {
        this.cartItems = JSON.parse(storedItems);
      }
    }
  }

  saveCartItems() {
    localStorage.setItem('cartItems', JSON.stringify(this.cartItems));
  }

  // Método para agregar un producto al carrito
  addToCart(producto: Product) {
    const existingItem = this.cartItems.find(item => item.productoId === producto.productoId);
    if (existingItem) {
      existingItem.quantity++;
    } else {
      this.cartItems.push({ ...producto, quantity: 1 }); // Agregar el producto con cantidad 1
    }
    this.saveCartItems();
    this.calculateTotalPrice(); // Recalcular el precio total
  }

  // Método para eliminar un producto del carrito
  removeFromCart(index: number) {
    this.cartItems.splice(index, 1);
    this.saveCartItems();
    this.calculateTotalPrice(); // Recalcular el precio total
  }

  // Método para calcular el precio total del carrito
  calculateTotalPrice() {
    this.totalPrice = this.cartItems.reduce((total, item) => total + (item.precio * item.quantity), 0);
  }

  // Método para aumentar la cantidad de un producto
  increaseQuantity(index: number) {
    this.cartItems[index].quantity++;
    this.saveCartItems();
    this.calculateTotalPrice(); // Recalcular el precio total
  }

  // Método para disminuir la cantidad de un producto
  decreaseQuantity(index: number) {
    if (this.cartItems[index].quantity > 1) {
      this.cartItems[index].quantity--;
    } else {
      this.removeFromCart(index);
    }
    this.saveCartItems();
    this.calculateTotalPrice(); // Recalcular el precio total
  }
}
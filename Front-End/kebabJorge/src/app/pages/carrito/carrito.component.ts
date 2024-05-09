import { Component, OnInit } from '@angular/core';
import { Product } from '../../models/product';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-carrito',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './carrito.component.html',
})
export class CarritoComponent implements OnInit {
  cartItems: Product[] = [];
  totalPrice: number = 0;

  constructor() { }

  ngOnInit(): void {
    this.loadCartItems();
    this.calculateTotalPrice();
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

  addToCart(producto: Product) {
    const existingItem = this.cartItems.find(item => item.productoId === producto.productoId);
    if (existingItem) {
      existingItem.quantity++;
    } else {
      this.cartItems.push({ ...producto, quantity: 1 });
    }
    this.saveCartItems();
    this.calculateTotalPrice();
  }

  removeFromCart(index: number) {
    this.cartItems.splice(index, 1);
    this.saveCartItems();
    this.calculateTotalPrice();
  }

  calculateTotalPrice() {
    this.totalPrice = this.cartItems.reduce((total, item) => total + (item.precio * item.quantity), 0);
  }

  increaseQuantity(index: number) {
    this.cartItems[index].quantity++;
    this.saveCartItems();
    this.calculateTotalPrice();
  }

  decreaseQuantity(index: number) {
    if (this.cartItems[index].quantity > 1) {
      this.cartItems[index].quantity--;
    } else {
      this.removeFromCart(index);
    }
    this.saveCartItems();
    this.calculateTotalPrice();
  }
}
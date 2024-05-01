export interface Product {
  productoId: number;
  nombre: string;
  descripcion: string;
  precio: number;
  tipo: number;
  imageUrl: string;
  ingredientes: string[];
  quantity: number;
}
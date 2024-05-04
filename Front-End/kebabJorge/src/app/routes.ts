import { Routes } from '@angular/router';
import { ProductosComponent } from './pages/productos/productos.component';
import { ProveedoresComponent } from './pages/proveedores/proveedores.component';
import { TopBarComponent } from './modules/core/components/top-bar/top-bar.component';
import { DetalleProductoComponent } from './pages/detalle-producto/detalle-producto.component';
import { CarritoComponent } from './pages/carrito/carrito.component';
import { ErrorComponent } from './modules/core/components/error/error.component';
import { PoliticaComponent } from './modules/core/components/politica/politica.component';
import { InicioComponent } from './pages/inicio/inicio.component';

export const routes: Routes = [
  {
    path: '',
    component: InicioComponent,
  },{
    path: 'productos',
    component: ProductosComponent
  },{
    path: 'inicio',
    component: InicioComponent
  },{
    path: 'nuestra-politica',
    component: PoliticaComponent
  },{
    path: 'productos/type/:tipo',
    component: ProductosComponent
  },{
    path: 'productos/:id',
    component: DetalleProductoComponent
  },{
    path: 'proveedores',
    component: ProveedoresComponent
  },{
    path: 'proveedores/:id',
    component: ProveedoresComponent
  },{
    path: 'cart',
    component: CarritoComponent,
  },{
    path: 'topbar',
    component: TopBarComponent,
  },{
    path: '**',
    component: ErrorComponent,
  }
];
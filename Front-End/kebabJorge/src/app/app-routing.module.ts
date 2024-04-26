import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ProductosComponent } from './pages/productos/productos.component';
import { ProveedoresComponent } from './pages/proveedores/proveedores.component';

export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },{
    path: 'productos',
    component: ProductosComponent,
  },{
    path: 'productos/:id',
    component: ProductosComponent,
  },{
    path: 'proveedores',
    component: ProveedoresComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],  
  exports: [RouterModule]
})
export class AppRoutingModule { }

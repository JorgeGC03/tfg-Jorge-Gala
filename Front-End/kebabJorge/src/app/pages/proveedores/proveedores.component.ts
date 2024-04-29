import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-proveedores',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './proveedores.component.html',
  styleUrl: './proveedores.component.scss'
})
export class ProveedoresComponent{


}


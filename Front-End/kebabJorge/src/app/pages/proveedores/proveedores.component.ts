import { CommonModule } from '@angular/common';
import { Component, OnInit, Provider } from '@angular/core';
import { ActivatedRoute, Router, RouterOutlet } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ProveedorService } from '../../services/proveedor.service';
import { Proveedores } from '../../models/provider';
import {MatPaginatorModule} from '@angular/material/paginator';

@Component({
  selector: 'app-proveedores',
  standalone: true,
  imports: [RouterOutlet, CommonModule, HttpClientModule, MatPaginatorModule],
  templateUrl: './proveedores.component.html',
})


export class ProveedoresComponent implements OnInit{

  proveedores: Proveedores[] = [];
  

  constructor(private proveedorService: ProveedorService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getAllProviders();
  }

  getAllProviders() {
    this.proveedorService.getAllProviders().subscribe(response => {
      this.proveedores = response.data;
    });
  }
}


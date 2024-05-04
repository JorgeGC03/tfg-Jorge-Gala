import { Component, OnInit, Provider } from '@angular/core';
import { ActivatedRoute, Router, RouterOutlet } from '@angular/router';
import { ProveedorService } from '../../services/proveedor.service';
import { Proveedores } from '../../models/provider';

@Component({
  selector: 'app-proveedores',
  standalone: true,
  imports: [RouterOutlet],
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


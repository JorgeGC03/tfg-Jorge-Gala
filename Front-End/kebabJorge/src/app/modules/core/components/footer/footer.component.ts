import { Component } from '@angular/core';
import { CarritoComponent } from '../../../../pages/carrito/carrito.component';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CarritoComponent],
  templateUrl: './footer.component.html',
})
export class FooterComponent {

}

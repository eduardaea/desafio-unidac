import { Component } from '@angular/core';

@Component({
  selector: 'app-brekker',
  templateUrl: './brekker.component.html',
  styleUrls: ['./brekker.component.css']
})
export class BrekkerComponent {

  visibleItem:boolean = false;
  visibleRegister:boolean = false;

  toggleMenu(){
    this.visibleItem = !this.visibleItem
    this.visibleRegister = false
  }
  newRegister(){
    this.visibleItem = false
    this.visibleRegister = true

  }
}

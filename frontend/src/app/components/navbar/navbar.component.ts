import { Component } from '@angular/core';
import { BrekkerService } from 'src/app/shared/services/brekker.service';
import { BrekkerModule } from '../brekker/brekker.module';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {


  data: Date; 

  constructor(private brekkerService: BrekkerService,
    private brekker: BrekkerModule){}
  
  createBrekker(){
    let brekker = {data:this.data}
    console.log("Entrou")
    return this.brekkerService.postBrekker(brekker).subscribe(
      (reponse)=>{
        console.log(reponse)
    })
  }
}

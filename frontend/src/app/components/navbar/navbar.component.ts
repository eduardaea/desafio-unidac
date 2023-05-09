import { Component } from '@angular/core';
import { BrekkerService } from 'src/app/shared/services/brekker.service';
import { DadosManipulator } from 'src/app/shared/utils/dadosManipulator';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  minDate:string
  data: Date; 

  constructor(private brekkerService: BrekkerService
    ){
      this.minDate = DadosManipulator.actualData()
    }
  
  createBrekker(){
    let brekker = {data:this.data}
    this.brekkerService.postBrekker(brekker).subscribe(
      (reponse)=>{
        window.location.reload()
    })
  }
}



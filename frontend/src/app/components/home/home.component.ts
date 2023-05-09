import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Brekker } from 'src/app/shared/model/Brekker';
import { BrekkerService } from 'src/app/shared/services/brekker.service';
import { DadosManipulator } from 'src/app/shared/utils/dadosManipulator';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
  
  allBrekker: Brekker[] = [] 
  recentBrekker: Brekker;
  editDate: Date;
  minDate: string

  constructor(private route: Router,
    private brekkerService: BrekkerService){
      this.minDate = DadosManipulator.actualData()
    }
  
  ngOnInit(): void {
   this.listBrekker();
  }

  goBrekker(brekker:Brekker){
    this.route.navigate(['cafe',brekker.id])
  }

  listBrekker(){
    this.brekkerService.getAllBrekker().subscribe(
      (response)=>{
        this.allBrekker = response
      }
    )
  }
  deleteBrekker(brekker:Brekker){
    this.brekkerService.deleteBrekker(Number(brekker.id)).subscribe(()=>{
      this.listBrekker()
    })
  }

  editBrekker(){
    this.recentBrekker.data = this.editDate;
    this.brekkerService.updateBrekker(Number(this.recentBrekker.id),this.recentBrekker).subscribe(
      ()=>{
        this.listBrekker()
      })
  }

  modalBrekker(brekker:Brekker){
    this.recentBrekker = brekker
  }

}

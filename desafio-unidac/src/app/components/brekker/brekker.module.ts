import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrekkerComponent } from './brekker.component';
import { BrekkerRoutingModule } from './brekker-routing.module';

@NgModule({
  declarations: [
    BrekkerComponent
  ],
  imports: [
    CommonModule,
    BrekkerRoutingModule
  ],
  providers: [],
  exports: [BrekkerComponent]
})
export class BrekkerModule { }

import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrekkerComponent } from './brekker.component';
import { BrekkerRoutingModule } from './brekker-routing.module';
import { FormsModule } from '@angular/forms';
import { TextMaskModule } from 'angular2-text-mask';


@NgModule({
  declarations: [
    BrekkerComponent
  ],
  imports: [
    CommonModule,
    BrekkerRoutingModule,
    FormsModule,
    TextMaskModule
  ],
  providers: [],
  exports: [BrekkerComponent]
})
export class BrekkerModule { }

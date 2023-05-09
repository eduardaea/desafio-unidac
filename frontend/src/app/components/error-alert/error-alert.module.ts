import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ErrorAlertComponent } from './error-alert.component';

@NgModule({
  declarations: [
    ErrorAlertComponent
  ],
  imports: [
    CommonModule
  ],
  providers: [],
  exports: [ErrorAlertComponent]
})
export class ErrorAlertModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BrekkerComponent } from './brekker.component';


const routes: Routes = [
  {
    path: 'cafe',
    component: BrekkerComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class BrekkerRoutingModule {}

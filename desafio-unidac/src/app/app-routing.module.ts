import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('./components/home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'cafe',
    loadChildren: () =>
      import('./components/brekker/brekker.module').then((m) => m.BrekkerModule),
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
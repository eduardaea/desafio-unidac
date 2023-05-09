import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeModule } from './components/home/home.module';
import { RouterModule } from '@angular/router';
import { BrekkerModule } from './components/brekker/brekker.module';
import { NavBarModule } from './components/navbar/navbar.module';
import { HttpClientModule } from '@angular/common/http';
import { ErrorAlertModule } from './components/error-alert/error-alert.module';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    HomeModule,
    BrekkerModule,
    RouterModule,
    NavBarModule,
    HttpClientModule,
    ErrorAlertModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

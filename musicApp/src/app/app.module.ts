import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { TokenInterceptor } from './guard/token.interceptor';

import { AppRoutingModule } from './app-routing/app-routing.module';

@NgModule({
    declarations: [ 
    ],
    imports: [
      BrowserModule,
      AppRoutingModule, // Asegúrate de que está aquí
      HttpClientModule
    ],
    providers: [
        { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },
      ],
    bootstrap: []
  })
  export class AppModule { }
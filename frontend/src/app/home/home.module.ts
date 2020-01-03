import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductDetailComponent } from '../components/product-detail/product-detail.component';
import { CartComponent } from '../components/cart/cart.component';
import { NavBarComponent } from '../components/navbar/navbar.component';
import { HomeComponent } from './home.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { HomeRoutingModule } from './home-routing.module';
import { MatCommonModule, MatRippleModule } from '@angular/material';

@NgModule({
  imports: [
    CommonModule,
    HomeRoutingModule,
    MatCommonModule, 
    MatRippleModule,
    BrowserModule,
    FormsModule
  ],
  declarations: [
    HomeComponent,
    CartComponent,
    NavBarComponent,
    ProductDetailComponent,
  ]
})
export class HomeModule { }

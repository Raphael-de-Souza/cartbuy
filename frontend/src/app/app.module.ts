import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatCommonModule, MatRippleModule } from '@angular/material';
import { AppRoutingModule } from './app-routing.module';
import { MatCardModule } from '@angular/material/card';

import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

import { COMPONENTS } from './components';
import { SERVICES } from './services';
import { ACTIONS } from './store/actions';
import { reducers, metaReducers } from './store/reducers';
import { AllEffects } from './store/effects';
import { AuthGuard } from './guards/index';

import { HomeModule } from './home/home.module';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProductComponent } from './components/product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
       ProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatCommonModule,
    MatRippleModule,
    MatCardModule,
    StoreModule.forRoot(reducers
      // { metaReducers }
    ),
    // StoreDevtoolsModule.instrument({
    //   maxAge: 25 //  Retains last 25 states
    // }),
    AllEffects,
    HomeModule
 
  ],
  providers: [AuthGuard , SERVICES, ACTIONS],
  bootstrap: [AppComponent]
})
export class AppModule { }

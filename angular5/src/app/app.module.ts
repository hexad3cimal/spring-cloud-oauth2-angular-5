import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {routing} from "./routing/core-routing.module";
import { DashboardComponent } from './dashboard/dashboard.component';
import {SharedModule} from "./shared/shared.module";
import {AuthserviceService} from "./services/authservice.service";
import {RestcallsService} from "./services/restcalls.service";
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './login/login.component';
import {FormsModule} from "@angular/forms";
import {AuthenticationService} from "./authentication/auth";
import {CustomHttpInterceptor} from "./utils/CustomHttpInterceptor";
import {HTTP_INTERCEPTORS} from "@angular/common/http";


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,routing, FormsModule, SharedModule, HttpClientModule
  ],
  providers: [ AuthenticationService, RestcallsService, AuthserviceService,
    {  provide: HTTP_INTERCEPTORS,
      useClass: CustomHttpInterceptor,
      multi: true
    },],
  bootstrap: [AppComponent]
})
export class AppModule { }

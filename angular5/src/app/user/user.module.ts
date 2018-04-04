import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SharedModule} from "../shared/shared.module";
import { AdduserComponent } from './adduser/adduser.component';
import {routing} from "./user.routes";
import { UserdashboardComponent } from './userdashboard/userdashboard.component';

@NgModule({
  imports: [
    CommonModule, SharedModule, routing
  ],
  declarations: [AdduserComponent, UserdashboardComponent]
})
export class UserModule { }

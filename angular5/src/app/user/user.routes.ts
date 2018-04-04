/**
 * Created by hexad3cimal on 1/3/17.
 */
import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AdduserComponent} from "./adduser/adduser.component";
import {UserdashboardComponent} from "./userdashboard/userdashboard.component";


// Route Configuration
export const userroutes: Routes = [
  {
    path: 'add',
   component : AdduserComponent,
 },
  {
    path: '',
    component : UserdashboardComponent,
  }
];


export const routing: ModuleWithProviders = RouterModule.forChild(userroutes);

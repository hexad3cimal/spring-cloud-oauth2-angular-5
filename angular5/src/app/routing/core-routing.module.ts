/**
 * Created by hexad3cimal on 1/3/17.
 */
import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DashboardComponent} from "../dashboard/dashboard.component";
import {LoginComponent} from "../login/login.component";

// Route Configuration
export const routes: Routes = [
  {
    path:'',
    component:DashboardComponent
  },
  {
    path:'login',
    component:LoginComponent
  },
    {
    path: 'user',
    loadChildren: './user/user.module#UserModule'
    },

  {
    path: 'book',
    loadChildren: './booksession/booksession.module#BooksessionModule'
  }
];


export const routing: ModuleWithProviders = RouterModule.forRoot(routes);

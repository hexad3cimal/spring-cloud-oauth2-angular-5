import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ReactiveFormsModule} from "@angular/forms";
import {SidebarComponent} from "../sidebar/sidebar.component";
import {NavbarComponent} from "../navbar/navbar.component";

@NgModule({
  imports: [
    CommonModule, ReactiveFormsModule
  ],
  declarations: [SidebarComponent, NavbarComponent],
  exports: [ReactiveFormsModule,SidebarComponent, NavbarComponent],
})
export class SharedModule { }

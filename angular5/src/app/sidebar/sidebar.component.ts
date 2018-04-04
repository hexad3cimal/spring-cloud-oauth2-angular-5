import { Component, OnInit } from '@angular/core';
import {Theme} from "../properties/theme";

@Component({
  selector: 'sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor() { }
public themeColor : string;
  ngOnInit() {
    this.themeColor = Theme.themeColor;
  }

}

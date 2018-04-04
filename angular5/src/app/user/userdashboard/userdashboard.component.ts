import { Component, OnInit } from '@angular/core';
import {RestcallsService} from "../../services/restcalls.service";

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

  constructor(private restCall : RestcallsService) { }

  ngOnInit() {

    this.getAllUsers();
  }

  public users;

  getAllUsers(){

    this.restCall.get("http://localhost:8080/user/get/all=all").subscribe(
      data => {
        this.users = data
      }
    )
  }

}

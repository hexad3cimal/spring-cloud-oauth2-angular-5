import { Component, OnInit } from '@angular/core';
import {AuthenticationService} from "../authentication/auth";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth : AuthenticationService) { }

  ngOnInit() {
  }
public username:string;
  public password:string;

  processLogin(){
    this.auth.login(this.username, this.password).subscribe(
      data => {
        if (data && data.access_token)
              localStorage.setItem("token",data.access_token);
      }
    );
  }
}

import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder} from "@angular/forms";
import {RestcallsService} from "../../services/restcalls.service";

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  public addUserForm :FormGroup;
  public roles;
  public rolesDropDown;
  public isStudent:boolean;
  public isTutor:boolean;
  public isCustomerCare:boolean;
  public user;

  constructor(private fb :FormBuilder, private rest:RestcallsService) {

    this.createForm();
    this.rolesDropDown = "Select user role";
  }

  onRolesDropDownSelect(value){
    this.rolesDropDown = value;
    if(value === "STUDENT")
    {
      this.isStudent == true;
    }
    if(value === "TUTOR")
      {
      this.isTutor == true;

    }
  }

  ngOnInit() {
    this.getRoles();
  }

  getRoles(){
    this.rest.get("http://localhost:8080/roles/listall").subscribe( data =>{
      this.roles = data;
    }, error =>{
      console.log(error);
    })
  }

createForm(){
  this.addUserForm = this.fb.group({
    firstname:'',
    lastname:'',
    email:'',
    grade:'',
    gtalk:'',
    skypeId:'',
    parentName:'',
    description:'',
    password:'',
    title:'',
    nameOfOrganisation:'',
    descriptionOfRole:''

  })
}




}

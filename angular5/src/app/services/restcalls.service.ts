import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class RestcallsService {

  constructor(private http:HttpClient) { }


  post(data, url ,upload){

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'my-auth.ts-token'
      })
    };
    return this.http.post(url, data, httpOptions);
  }

  get(url){
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
      })
    };
    return this.http.get(url,httpOptions);
  }

}

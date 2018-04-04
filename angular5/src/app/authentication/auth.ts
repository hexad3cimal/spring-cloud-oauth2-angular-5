import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import 'rxjs/add/operator/map'
import {appConfig} from "../constants/app.config";

@Injectable()
export class AuthenticationService {
  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    let params = new HttpParams();
    params = params.append('username',username);
    params = params.append('password',password);
    params = params.append('grant_type','password');
    params = params.append('client_id','web_app');

    let headers = new HttpHeaders({'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
      "Authorization" : "Basic " + btoa("web_app" + ":" + '')});
    return this.http.post<any>(appConfig.baseUrl + "auth/oauth/token", '', { headers: headers, params : params} );
  }

  logout() {
    localStorage.removeItem('token');
  }
}

import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { HttpRequest } from '@angular/common/http';
import { HttpHandler } from '@angular/common/http';
import { HttpEvent } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import {HttpResponse} from "@angular/common/http";
import {HttpErrorResponse} from "@angular/common/http";
import 'rxjs/add/operator/do';


@Injectable()
export class CustomHttpInterceptor implements HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
   const token = localStorage.getItem("token");
    let changedRequest = request;
    // HttpHeader object immutable - copy values
    const headerSettings: {[name: string]: string | string[]; } = {};

    for (const key of request.headers.keys()) {
      headerSettings[key] = request.headers.getAll(key);
    }
    if (token) {
      headerSettings['Authorization'] = 'Bearer ' + token;
    }
    const newHeader = new HttpHeaders(headerSettings);

    changedRequest = request.clone({
      headers: newHeader});
    return next.handle(changedRequest).do((event: HttpEvent<any>) => {
      if (event instanceof HttpResponse) {
          console.log("lll")
      }
    }, (err: any) => {
      if (err instanceof HttpErrorResponse ){
        if (err.status === 0 || err.status === 401) {
            localStorage.removeItem("token");
        }
      }
    });
  }
}

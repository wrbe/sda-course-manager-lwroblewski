import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HeadersService {



  constructor() {

  }

  public getHeaders(): HttpHeaders {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa('admin:admin'));
    return headers;
  }}

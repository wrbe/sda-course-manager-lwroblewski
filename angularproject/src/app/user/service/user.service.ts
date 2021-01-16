import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public usersUrl: string;

  constructor(private httpClient: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public getUserList(): Observable<User[]> {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa('admin:admin'))
    return this.httpClient.get<User[]>(this.usersUrl, {headers: headers});
  }

}

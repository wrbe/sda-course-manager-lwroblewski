import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Course} from "../model/course/course";
import {CoursesDetails} from "../model/course-details/courses-details";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  courseUrl: string;

  constructor(private httpClient: HttpClient) {
    this.courseUrl = 'http://localhost:8080/api/courses';
  }

  public getCoursesList(): Observable<Course[]> {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa('admin:admin'));
    return this.httpClient.get<Course[]>(this.courseUrl, {headers: headers});
  }

  public getCourse(id : number): Observable<CoursesDetails> {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa('admin:admin'));
    return this.httpClient.get<CoursesDetails>(this.courseUrl + '/info/' + id, {headers: headers});
  }

}

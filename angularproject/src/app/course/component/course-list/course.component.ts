import { Component, OnInit } from '@angular/core';
import {Course} from "../../model/course/course";
import {CourseService} from "../../service/course.service";

@Component({
  selector: 'app-component',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  courses: Course[];
  course: Course;

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {

    this.courseService.getCoursesList().subscribe(data => {
      this.courses = data });
  }

}

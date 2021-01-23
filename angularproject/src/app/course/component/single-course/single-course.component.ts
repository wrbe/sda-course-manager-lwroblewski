import { Component, OnInit } from '@angular/core';
import {Course} from "../../model/course/course";
import {CourseService} from "../../service/course.service";
import {User} from "../../../user/model/user";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../../user/service/user.service";
import {CoursesDetails} from "../../model/course-details/courses-details";

@Component({
  selector: 'app-single-course',
  templateUrl: './single-course.component.html',
  styleUrls: ['./single-course.component.css']
})
export class SingleCourseComponent implements OnInit {

  course: CoursesDetails;

  constructor(private route: ActivatedRoute, private courseService: CourseService) {
  }

  ngOnInit(): void {

    let courseId = this.route.snapshot.params['id'];
    this.courseService.getCourse(courseId).subscribe(data => this.course = data);
  }
}

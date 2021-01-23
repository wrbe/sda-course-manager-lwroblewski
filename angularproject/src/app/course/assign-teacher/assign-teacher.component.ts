import { Component, OnInit } from '@angular/core';
import {User} from "../../user/model/user";
import {ActivatedRoute} from "@angular/router";
import {LessonServiceService} from "../../lesson/service/lesson-service.service";
import {UserService} from "../../user/service/user.service";

@Component({
  selector: 'app-assign-teacher',
  templateUrl: './assign-teacher.component.html',
  styleUrls: ['./assign-teacher.component.css']
})
export class AssignTeacherComponent implements OnInit {

  public teacherId: number;
  public lessonBlockId: number;
  public teachers: User[];

  constructor(private route: ActivatedRoute, private lessonService: LessonServiceService,
              private userService: UserService) { }

  ngOnInit(): void {
    this.lessonBlockId = this.route.snapshot.queryParams['lessonBlockId'];
    this.userService.getTeacherList().subscribe(data => {
      this.teachers = data;
    });
  }

  onSubmit() {
    this.lessonService.assignTeacher(this.teacherId, this.lessonBlockId);
  }

}

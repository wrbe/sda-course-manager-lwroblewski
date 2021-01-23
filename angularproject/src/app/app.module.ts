import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './user/component/user-list/user-list.component';
import {UserService} from "./user/service/user.service";
import {HttpClientModule} from "@angular/common/http";
import { CourseComponent } from './course/component/course-list/course.component';
import {CourseService} from "./course/service/course.service";
import { SingleCourseComponent } from './course/component/single-course/single-course.component';
import { UserComponent } from './user/user/user.component';
import { LessonComponent } from './lesson/components/lesson/lesson/lesson.component';
import { AssignTeacherComponent } from './course/assign-teacher/assign-teacher.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    CourseComponent,
    SingleCourseComponent,
    UserComponent,
    LessonComponent,
    AssignTeacherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }

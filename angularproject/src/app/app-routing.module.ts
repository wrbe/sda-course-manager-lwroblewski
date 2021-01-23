import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserListComponent} from "./user/component/user-list/user-list.component";
import {CourseComponent} from "./course/component/course-list/course.component";
import {UserComponent} from "./user/user/user.component";
import {SingleCourseComponent} from "./course/component/single-course/single-course.component";
import {AssignTeacherComponent} from "./course/assign-teacher/assign-teacher.component";

const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'users/:id', component: UserComponent },
  { path: 'courses', component: CourseComponent },
  { path: 'courses/assign-teacher', component: AssignTeacherComponent },
  { path: 'courses/:id', component: SingleCourseComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

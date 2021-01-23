import {Lesson} from "../lesson/lesson";

export class LessonBlock {

  id: number;
  subject: string;
  teacherId: number;
  teacherName: string;
  lessons: Lesson[];
}

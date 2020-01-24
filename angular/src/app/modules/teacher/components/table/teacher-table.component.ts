import {Component, Input} from '@angular/core';
import {Teacher} from '../../models/teacher.model';


@Component({
  selector: 'app-teacher-table',
  templateUrl: 'teacher-table.component.html',
  styleUrls: ['./teacher-table.component.css']
})
export class TeacherTableComponent {

  @Input() public _teachers: Teacher[];

  constructor() { }

}

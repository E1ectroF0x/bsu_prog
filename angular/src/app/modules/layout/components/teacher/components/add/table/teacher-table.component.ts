import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Teacher} from '../../../models/teacher.model';
import {TeacherService} from '../../../../../../../services/teacher.service';
import {Subscription} from 'rxjs';


@Component({
  selector: 'app-teacher-table',
  templateUrl: 'teacher-table.component.html',
  styleUrls: ['./teacher-table.component.css']
})
export class TeacherTableComponent implements OnInit, OnDestroy {

  @Input() public _teachers: Teacher[];

  constructor() { }

  ngOnInit(): void { }

  ngOnDestroy(): void { }

}

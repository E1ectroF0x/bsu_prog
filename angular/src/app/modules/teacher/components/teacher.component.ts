import {Component, OnInit} from '@angular/core';
import {TeacherService} from '../../../services/teacher.service';
import {Teacher} from '../teacher.model';


@Component({
  selector: 'app-teacher',
  templateUrl: 'teacher.component.html',
  styleUrls: ['teacher.component.css']
})
export class TeacherComponent implements OnInit{

  public _teachers: Teacher[];

  constructor(private teacherService: TeacherService) { }

  ngOnInit(): void {
    this.teacherService.getAll().subscribe(teachers => this._teachers = teachers);
  }

}

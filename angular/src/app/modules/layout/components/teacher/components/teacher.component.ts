import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {Subscription} from 'rxjs';
import {Teacher} from '../models/teacher.model';
import {TeacherService} from '../../../../../services/teacher.service';


@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit, OnDestroy{

  public _title: string = 'Преподаватели';
  public _teachers: Teacher[];
  private subscriptions: Subscription[] = [];

  constructor(private teacherService: TeacherService) { }

  ngOnInit(): void {
    this.loadTeachers();
  }

  public _updateTable(): void {
    this.loadTeachers();
  }

  private loadTeachers(): void {
    this.subscriptions.push(this.teacherService.getAll().subscribe(teachers => {
      this._teachers = teachers;
      console.log("Teachers loaded successfully");
    }))
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}

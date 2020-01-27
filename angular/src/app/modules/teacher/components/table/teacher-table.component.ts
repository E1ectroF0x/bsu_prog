import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Teacher} from '../../models/teacher.model';
import {TeacherService} from '../../../../services/teacher.service';
import {Subscription} from 'rxjs';


@Component({
  selector: 'app-teacher-table',
  templateUrl: 'teacher-table.component.html',
  styleUrls: ['./teacher-table.component.css']
})
export class TeacherTableComponent implements OnInit, OnDestroy {

  public _teachers: Teacher[];
  private subscriptions: Subscription[] = [];

  constructor(private teacherService: TeacherService) { }

  ngOnInit(): void {
      this.subscriptions.push(this.teacherService.getAll().subscribe(teachers => {
        this._teachers = teachers;
        console.log("Teachers loaded successfully");
      }))
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}

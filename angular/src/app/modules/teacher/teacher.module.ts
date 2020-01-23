import {NgModule} from '@angular/core';
import {TeacherComponent} from './components/teacher.component';
import {TeacherService} from '../../services/teacher.service';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {TeacherTableComponent} from './components/table/teacher-table.component';


@NgModule({
  declarations: [
    TeacherComponent,
    TeacherTableComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    TeacherService
  ],
  exports: [
    TeacherComponent
  ]
})
export class TeacherModule { }

import {NgModule} from '@angular/core';
import {TeacherComponent} from './components/teacher.component';
import {TeacherService} from '../../services/teacher.service';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {TeacherTableComponent} from './components/table/teacher-table.component';
import {AddTeacherComponent} from './components/add/add-teacher.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    TeacherComponent,
    TeacherTableComponent,
    AddTeacherComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    TeacherService
  ],
  exports: [
    TeacherComponent
  ]
})
export class TeacherModule { }

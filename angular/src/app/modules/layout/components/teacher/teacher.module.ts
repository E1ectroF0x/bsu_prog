import {NgModule} from '@angular/core';
import {TeacherComponent} from './components/teacher.component';
import {TeacherService} from '../../../../services/teacher.service';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {TeacherTableComponent} from './components/add/table/teacher-table.component';
import {FormsModule} from '@angular/forms';
import {FacultyService} from '../../../../services/faculty.service';
import {DepartmentService} from '../../../../services/department.service';
import {HeaderModule} from '../header/header.module';
import {NavbarModule} from '../navbar/navbar.module';
import {AddTeacherComponent} from './components/add/add-teacher.component';


@NgModule({
  declarations: [
    TeacherComponent,
    TeacherTableComponent,
    AddTeacherComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    HeaderModule,
    NavbarModule
  ],
  providers: [
    TeacherService,
    FacultyService,
    DepartmentService
  ],
  exports: [
    TeacherComponent
  ]
})
export class TeacherModule { }

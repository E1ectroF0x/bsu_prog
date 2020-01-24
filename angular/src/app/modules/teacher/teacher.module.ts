import {NgModule} from '@angular/core';
import {TeacherComponent} from './components/teacher.component';
import {TeacherService} from '../../services/teacher.service';
import {BrowserModule} from '@angular/platform-browser';


@NgModule({
  declarations: [
    TeacherComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    TeacherService
  ],
  exports: [
    TeacherComponent
  ]
})
export class TeacherModule {

}

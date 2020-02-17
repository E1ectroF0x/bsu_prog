import {NgModule} from '@angular/core';
import {HeaderModule} from './components/header/header.module';
import {HomeModule} from './components/home/home.module';
import {NavbarModule} from './components/navbar/navbar.module';
import {TeacherModule} from './components/teacher/teacher.module';
import {LoginComponent} from './components/login/login.component';
import {StorageService} from '../../services/storage.service';
import {UsersService} from '../../services/user.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {TimetableComponent} from './components/timetable/components/timetable.component';
import {TimetableModule} from './components/timetable/timetable.module';


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    HeaderModule,
    NavbarModule,
    HomeModule,
    TeacherModule,
    TimetableModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ],
  providers: [
    StorageService,
    UsersService,
    AuthService
  ],
  exports: [LoginComponent]
})
export class LayoutModule {}

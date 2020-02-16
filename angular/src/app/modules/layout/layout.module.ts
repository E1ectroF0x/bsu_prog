import {NgModule} from '@angular/core';
import {HeaderModule} from './components/header/header.module';
import {HomeModule} from './components/home/home.module';
import {NavbarModule} from './components/navbar/navbar.module';
import {TeacherModule} from '../teacher/teacher.module';
import {LoginComponent} from './components/login/login.component';
import {StorageService} from '../../services/storage.service';
import {UsersService} from '../../services/user.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';


@NgModule({
  declarations: [
    LoginComponent
  ],
  imports: [
    HeaderModule,
    NavbarModule,
    HomeModule,
    TeacherModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ],
  providers: [
    StorageService,
    UsersService
  ],
  exports: [LoginComponent]
})
export class LayoutModule {}

import {NgModule} from '@angular/core';
import {HomeComponent} from './components/home.component';
import {HeaderModule} from '../header/header.module';
import {NavbarModule} from '../navbar/navbar.module';
import {TeacherModule} from '../teacher/teacher.module';


@NgModule({
  declarations: [
    HomeComponent
  ],
    imports: [
        HeaderModule,
        NavbarModule,
        TeacherModule
    ],
  providers: [],
  exports: [
    HomeComponent
  ]
})
export class HomeModule { }

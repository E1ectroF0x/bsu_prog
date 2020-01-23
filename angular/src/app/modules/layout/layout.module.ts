import {NgModule} from '@angular/core';
import {HeaderModule} from './components/header/header.module';
import {HomeModule} from './components/home/home.module';
import {NavbarModule} from './components/navbar/navbar.module';
import {TeacherModule} from '../teacher/teacher.module';


@NgModule({
  declarations: [],
  imports: [
    HeaderModule,
    NavbarModule,
    HomeModule,
    TeacherModule
  ],
  providers: [],
  exports: []
})
export class LayoutModule {}

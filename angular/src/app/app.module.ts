import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {LayoutModule} from './modules/layout/layout.module';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './modules/layout/components/home/components/home.component';
import {TeacherModule} from './modules/layout/components/teacher/teacher.module';
import {LoginComponent} from './modules/layout/components/login/login.component';
import {TeacherComponent} from './modules/layout/components/teacher/components/teacher.component';
import {TimetableComponent} from './modules/timetable/components/timetable.component';
import {TimetableModule} from './modules/timetable/timetable.module';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'teachers', component: TeacherComponent},
  {path: 'timetable', component: TimetableComponent}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    LayoutModule,
    TeacherModule,
    TimetableModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

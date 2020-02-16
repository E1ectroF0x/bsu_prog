import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {LayoutModule} from './modules/layout/layout.module';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './modules/layout/components/home/components/home.component';
import {TeacherModule} from './modules/teacher/teacher.module';
import {LoginComponent} from './modules/layout/components/login/login.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    LayoutModule,
    TeacherModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

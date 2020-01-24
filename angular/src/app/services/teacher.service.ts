import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Teacher} from '../modules/teacher/models/teacher.model';
import {SaveTeacherModel} from '../modules/teacher/models/save-teacher.model';


@Injectable()
export class TeacherService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>('/api/teachers/all');
  }

  save(model: SaveTeacherModel): Observable<void> {
    return this.http.post<void>('/api/teachers', model);
  }

}

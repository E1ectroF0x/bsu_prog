import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Teacher} from '../modules/teacher/models/teacher.model';


@Injectable()
export class TeacherService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<Teacher[]> {
    return this.http.get<Teacher[]>('/api/teachers/all');
  }

  save(model: Teacher): Observable<void> {
    return this.http.post<void>('/api/teachers', model);
  }

  delete(model: Teacher): Observable<void> {
    const fd = new FormData();
    fd.append('name', model.name);
    fd.append('secondName', model.secondName);
    fd.append('lastName', model.lastName);
    // TODO: Add formData support
    return this.http.delete<void>('/api/teachers');
  }

}

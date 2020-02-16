import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FacultyModel} from '../modules/layout/components/teacher/models/faculty.model';


@Injectable()
export class FacultyService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<FacultyModel[]> {
    return this.http.get<FacultyModel[]>('api/faculty/all');
  }
}

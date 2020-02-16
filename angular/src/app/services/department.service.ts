import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DepartmentModel} from '../modules/layout/components/teacher/models/department.model';


@Injectable()
export class DepartmentService {

  constructor(private http: HttpClient) {}

  getAll(): Observable<DepartmentModel[]> {
    return this.http.get<DepartmentModel[]>('api/departments/all');
  }

  getAllByFaculty(facultyName: string): Observable<DepartmentModel[]> {
    return this.http.get<DepartmentModel[]>('api/departments/all/' + facultyName);
  }

}

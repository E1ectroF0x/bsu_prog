import {Component, OnDestroy, OnInit} from '@angular/core';
import {Teacher} from '../../models/teacher.model';
import {TeacherService} from '../../../../services/teacher.service';
import {FacultyModel} from '../../models/faculty.model';
import {FacultyService} from '../../../../services/faculty.service';
import {Subscription} from 'rxjs';
import {DepartmentModel} from '../../models/department.model';
import {DepartmentService} from '../../../../services/department.service';


@Component({
  selector: 'app-teacher-add',
  templateUrl: 'add-teacher.component.html',
  styleUrls: ['./add-teacher.component.css']
})
export class AddTeacherComponent implements OnInit, OnDestroy {

  public _teacher: Teacher = new Teacher();
  public _faculties: FacultyModel[];
  public _departments: DepartmentModel[];
  public _selectedFaculty: string;

  private subscriptions: Subscription[] = [];

  constructor(private teacherService: TeacherService,
              private facultyService: FacultyService,
              private departmentService: DepartmentService) { }

  ngOnInit(): void {
    this.subscriptions.push(this.facultyService.getAll().subscribe(faculties => {
      this._faculties = faculties;
      this._selectedFaculty = faculties[0].name;
      this._loadDepartments();
      console.log("Faculties loaded successfully");
    }));
  }

  public _loadDepartments(): void {
    this.subscriptions.push(this.departmentService.getAllByFaculty(this._selectedFaculty).subscribe(departments => {
      this._departments = departments;
      this._teacher.departmentName = departments[0].name;
      console.log("Departments for faculty " + this._selectedFaculty + " loaded successfully");
    }))
  }


  public _saveTeacher(model: Teacher): void {
    console.log(model);
    this.subscriptions.push(this.teacherService.save(model).subscribe(data => console.log("OKAY")))
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}

import {Component} from '@angular/core';
import {Teacher} from '../../models/teacher.model';
import {TeacherService} from '../../../../services/teacher.service';
import {SaveTeacherModel} from '../../models/save-teacher.model';


@Component({
  selector: 'app-teacher-add',
  templateUrl: 'add-teacher.component.html',
  styleUrls: ['./add-teacher.component.css']
})
export class AddTeacherComponent {

  public _teacher: SaveTeacherModel = new SaveTeacherModel();

  constructor(private teacherService: TeacherService) { }

  public _saveTeacher(model: SaveTeacherModel) {
    this.teacherService.save(model).subscribe(data => console.log("OKAT"));
  }

}

import {Component, OnDestroy, OnInit} from '@angular/core';
import {UserModel} from './models/user.model';
import {Subscription} from 'rxjs';
import {AuthToken, UsersService} from '../../../../services/user.service';
import {StorageService} from '../../../../services/storage.service';
import {Router} from '@angular/router';


@Component ({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  public _loginModel: UserModel;
  private subscriptions: Subscription[] = [];

  constructor(private storageService: StorageService,
              private usersService: UsersService,
              public router: Router) {}

  public onSubmit(): void {
    console.log(this._loginModel);
    this._loginModel.device_id = '1';
    this.subscriptions.push(this.usersService.generateToken(this._loginModel).subscribe((authToken: AuthToken) => {
        if (authToken) {
          this.storageService.setToken(authToken.token);
          this.subscriptions.push(this.usersService.getAuthorizedUser().subscribe((userModel: UserModel) => {
            this.storageService.setCurrentUser(userModel);
            this.router.navigateByUrl('');
          }))
        }
    }))
  }

  ngOnInit(): void {
    this._loginModel = new UserModel();
  }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }
}

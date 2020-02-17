import {Component, Input} from '@angular/core';
import {StorageService} from '../../../../../services/storage.service';
import {Router} from '@angular/router';
import {AuthService} from '../../../../../services/auth.service';


@Component({
  selector: 'app-header',
  templateUrl: 'header.component.html',
  styleUrls: ['header.component.css']
})
export class HeaderComponent {

  @Input() public title: string;

  constructor(private storageService: StorageService,
              private authService: AuthService,
              private router: Router) {
  }

  public _isAuth(): boolean {
    return this.authService.isAuthentificated();
  }

  public _logout(): void {
    this.storageService.clearToken();
    this.storageService.setCurrentUser(null);
    this.router.navigateByUrl('');
  }

}

import {Component, Input} from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-navbar',
  templateUrl: 'navbar.component.html',
  styleUrls: ['navbar.component.css']
})
export class NavbarComponent {

  constructor(private router: Router) {
  }

  @Input() public _selectedPage: string;

  public _click_redirect(url: string): void {
    this.router.navigateByUrl(url);
  }

}

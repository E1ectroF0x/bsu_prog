import {Injectable} from '@angular/core';
import {StorageService} from './storage.service';
import {HttpClient} from '@angular/common/http';


@Injectable()
export class AuthService {

  constructor(private storageService: StorageService,
              private http: HttpClient) {}

  public isAuthentificated(): boolean {
    const token = localStorage.getItem('token');
    return token && token !== 'null' && !!this.storageService.getCurrentUser();
  }


}

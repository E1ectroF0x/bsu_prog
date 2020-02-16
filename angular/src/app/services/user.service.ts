import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserModel} from '../modules/layout/components/login/models/user.model';


@Injectable()
export class UsersService {

  constructor(private http: HttpClient) {}

  generateToken(model: UserModel): Observable<AuthToken> {
    return this.http.post<AuthToken>('/api/token/generate-token', model);
  }

  getAuthorizedUser(): Observable <UserModel> {
    return this.http.get<UserModel>('/api/users/current');
  }
}

export interface AuthToken {
  readonly token: string;
}

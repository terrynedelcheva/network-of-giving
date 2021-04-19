import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, mapTo, tap} from 'rxjs/operators';
import {Tokens} from '../tokens';
import {LoginUser} from '../login-user';

import {JwtHelperService} from '@auth0/angular-jwt';
import {Router} from '@angular/router';

const AUTH_API = 'http://localhost:8082/login';

/*const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};*/

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  jwtHelperService = new JwtHelperService();
  loginUser: LoginUser;
  username: string;

  constructor(private router: Router) {
    this.username = sessionStorage.getItem('username');
  }

  public isLoggedIn(): boolean {
    const jwt = localStorage.getItem('token');
    return !!jwt && !this.jwtHelperService.isTokenExpired(jwt);
  }

  public logoutUser(): boolean {
    localStorage.removeItem('token');
    sessionStorage.removeItem('username');
    this.router.navigate(['/charities']);
    return false;
  }

  public setUsername(username: string) {
    this.username = username;
    sessionStorage.setItem('username', this.username);
  }

  public getUsername(): string {
    return this.username;
  }
}


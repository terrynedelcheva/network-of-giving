import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpRequest} from '@angular/common/http';
import {User} from '../user';
import {Router} from '@angular/router';
import {LoginUser} from '../login-user';
import {Token} from '@angular/compiler';
import {Tokens} from '../tokens';
import {JwtHelperService} from '@auth0/angular-jwt';
import {AuthService} from '../services/auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  username: string;
  password: string;
  httpClient: HttpClient;
  jwtHelperService: JwtHelperService;
  isLoggedIn = true;

  constructor(http: HttpClient, private router: Router, private authService: AuthService) {
    this.httpClient = http;
  }

  ngOnInit(): void {
  }

  public loginUser() {
    /*const loginUser = new LoginUser();
    loginUser.username = this.username;
    loginUser.password = this.password;*/
    const loginUser: LoginUser = {
      username: this.username,
      password: this.password
    };
    this.authService.setUsername(this.username);
    this.httpClient.post('http://localhost:8082/login', loginUser).subscribe((response: Tokens) => {
        localStorage.setItem('token', response.token);
        console.log('Logged in successfully!');
        this.router.navigate(['/charities']);
      }, error => {
        console.log('Error occured!');
        this.isLoggedIn = false;
      }
    );
  }
}

import {Component, OnInit} from '@angular/core';
import {AuthService} from '../services/auth.service';
import {Router} from '@angular/router';
import {LoginUser} from '../login-user';

@Component({
  selector: 'app-logged-user-header',
  templateUrl: './logged-user-header.component.html',
  styleUrls: ['./logged-user-header.component.css']
})
export class LoggedUserHeaderComponent implements OnInit {
  isModalVisible = false;
  username: string;

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
  }

  public get isUserLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }

  public get loggedOut(): boolean {
    return this.authService.logoutUser();
  }

  public getUsername() {
    this.username = this.authService.getUsername();
    return this.username;
  }
}

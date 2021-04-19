import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpEventType, HttpRequest, HttpResponse} from '@angular/common/http';
import {User} from '../user';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  age: number;
  gender: string;
  location: string;
  httpClient: HttpClient;
  isRegistered = false;

  constructor(http: HttpClient) {
    this.httpClient = http;
  }

  ngOnInit(): void {
  }

  manageAge(n: number, startFrom: number): number[] {
    return [...Array(n).keys()].map(i => i + startFrom);
  }

  createUser() {
    let user = new User();
    user.username = this.username;
    user.password = this.password;
    user.firstName = this.firstName;
    user.lastName = this.lastName;
    user.age = this.age;
    user.gender = this.gender;
    user.location = this.location;
    const request = new HttpRequest('POST', 'http://localhost:8082/users', user);

    this.httpClient.request(request).subscribe(
      res => {
        console.log(res);
        this.isRegistered = true;
      },
      err => {
        console.log('Error occured');
      }
    );
  }
}

import {Component, OnDestroy, OnInit} from '@angular/core';
import {CharitiesService} from '../services/charities.service';
import {Charity} from '../charity';
import {NavigationEnd, Router} from '@angular/router';
import {AuthService} from '../services/auth.service';

@Component({
  selector: 'app-charities',
  templateUrl: './charities.component.html',
  styleUrls: ['./charities.component.css']
})
export class CharitiesComponent implements OnInit {
  charities: Charity[];
  private mySubscription: any;
  searchText: any;

  constructor(private charitiesService: CharitiesService, private router: Router, private authService: AuthService) {
    this.charitiesService.charityUrl = 'http://localhost:8082/charities';
  }

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.charitiesService.findAll().subscribe(
      charities => {
        this.charities = charities;
        console.log('Hi, getter of charities!');
      }, error => {
        console.log('Error getting charities!');
      }
    );
  }

  navigateToCharityDetails(id: number) {
    this.router.navigate(['/charity-details', id]);
  }

  public get isUserLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }
}

import {Component, Input, OnInit} from '@angular/core';
import {CharitiesService} from '../services/charities.service';
import {Charity} from '../charity';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {AuthService} from '../services/auth.service';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-charity-details',
  templateUrl: './charity-details.component.html',
  styleUrls: ['./charity-details.component.css']
})
export class CharityDetailsComponent implements OnInit {
  isVolunteerModalVisible = false;
  isDonationModalVisible = false;
  charityTitle: string;
  charityPath: string;
  charityDescription: string;
  donationCollected: number;
  donationRequired: number;
  volunteersRequired: number;
  volunteersCollected: number;
  isDeleteModalVisible = false;

  @Input() charity: Charity;

  constructor(private charitiesService: CharitiesService, private route: ActivatedRoute, private authService: AuthService, private router: Router) {
    this.charitiesService.charityUrl = 'http://localhost:8082/charities';
    this.router.routeReuseStrategy.shouldReuseRoute = function() {
      return false;
    };

    this.router.events.subscribe((evt) => {
      if (evt instanceof NavigationEnd) {
        // trick the Router into believing it's last link wasn't previously loaded
        this.router.navigated = false;
        // if you need to scroll back to top, here is the right place
        window.scrollTo(0, 0);
      }
    });
  }

  ngOnInit(): void {
    this.charity = new Charity();
    this.getCharity();
  }

  getCharity(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.charitiesService.getCharity(id).subscribe(charity => {
      this.charity = charity;
      this.charityTitle = charity.title;
      this.charityDescription = charity.description;
      this.donationCollected = charity.donationCollected;
      this.donationRequired = charity.donationRequired;
      this.volunteersRequired = charity.volunteersRequired;
      this.volunteersCollected = charity.volunteersCollected;
      console.log(this.donationCollected);
      /*console.log(this.volunteersCollected);*/
    });
  }

  deleteCharity(id: number) {
    this.charitiesService.deleteCharity(id).subscribe(
      data => {
        console.log(data);
        this.router.navigate(['/charities']);
      }, error => {
        {
          console.log(error);
        }
      }
    );
  }

  isDonationCollected(): boolean {
    if (this.charity.donationCollected >= this.charity.donationRequired) {
      this.charity.donationCollected = this.charity.donationRequired;
      return true;
    } else {
      return false;
    }
  }

  editCharityDonation() {
    this.charity.donationCollected = this.charity.donationCollected + this.donationCollected;
    if (this.charity.donationCollected >= this.charity.donationRequired) {
      this.charity.donationCollected = this.charity.donationRequired;
    }
    this.charitiesService.updateCharity(this.charity.id, this.charity).subscribe(
      res => {
        console.log(res);
        this.getCharity();
      }, error => {
        console.log('Error in editing charity!');
      }
    );

    this.charity = new Charity();
    this.isDonationModalVisible = false;
  }

  getCharityVolunteers() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.charitiesService.getCharity(id).subscribe(charity => {
      this.charity = charity;
      this.volunteersCollected = charity.volunteersCollected;
    });
  }

  editCharityVolunteers() {
    this.getCharityVolunteers();
    this.charity.volunteersCollected = this.charity.volunteersCollected + 1;
    if (this.charity.volunteersCollected >= this.charity.volunteersRequired) {
      this.charity.volunteersCollected = this.charity.volunteersRequired;
    }
    this.charitiesService.updateCharity(this.charity.id, this.charity).subscribe(
      res => {
        this.getCharity();
      }, error => {
        console.log(error);
      }
    );

    this.charity = new Charity();
    this.isVolunteerModalVisible = false;
  }

  public get isUserLoggedIn(): boolean {
    return this.authService.isLoggedIn();
  }
}

import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpEventType, HttpRequest, HttpResponse} from '@angular/common/http';
import {Charity} from '../charity';
import {UploadFileService} from '../upload/upload-file.service';

@Component({
  selector: 'app-create-charity',
  templateUrl: './create-charity.component.html',
  styleUrls: ['./create-charity.component.css']
})

export class CreateCharityComponent implements OnInit {
  title: string;
  image: string;
  description: string;
  donationRequired: number;
  donationCollected: number;
  volunteersRequired: number;
  volunteersCollected: number;
  httpClient: HttpClient;
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = {percentage: 0};
  charityPath: string;
  isCharityCreated = false;

  constructor(private uploadService: UploadFileService, http: HttpClient) {
    this.httpClient = http;
  }

  ngOnInit(): void {
  }

  createCharity() {
    let charity: Charity = new Charity();
    charity.title = this.title;
    charity.image = this.charityPath;
    charity.description = this.description;
    charity.donationRequired = this.donationRequired;
    charity.donationCollected = this.donationCollected;
    charity.volunteersRequired = this.volunteersRequired;
    charity.volunteersCollected = this.volunteersCollected;
    const req = new HttpRequest('POST', 'http://localhost:8082/charities/', charity);
    this.httpClient.request(req).subscribe(
      res => {
        console.log(req);
        this.isCharityCreated = true;
      },
      err => {
        console.log('Error occured!');
      }
    );
  }

  selectFile(event) {
    const file = event.target.files.item(0);

    if (file.type.match('image.*')) {
      this.selectedFiles = event.target.files;
    } else {
      alert('invalid format!');
    }
  }

  upload() {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      console.log(event);
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
        this.charityPath = String(event.body).valueOf();
        this.charityPath = 'http://localhost:8082' + this.charityPath;
      }
    });

    this.selectedFiles = undefined;
  }
}

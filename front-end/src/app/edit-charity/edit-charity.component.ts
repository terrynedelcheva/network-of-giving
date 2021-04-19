import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {HttpClient, HttpEventType, HttpRequest, HttpResponse} from '@angular/common/http';
import {UploadFileService} from '../upload/upload-file.service';
import {Charity} from '../charity';
import {CharitiesService} from '../services/charities.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-edit-charity',
  templateUrl: './edit-charity.component.html',
  styleUrls: ['./edit-charity.component.css']
})
export class EditCharityComponent implements OnInit {
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
  private charityPath: string;
  isCharityEdited = false;

  @Input() charity: Charity;
  @ViewChild('fileInput') fileInput;

  constructor(private uploadService: UploadFileService, http: HttpClient, private charitiesService: CharitiesService, private route: ActivatedRoute) {
    this.httpClient = http;
    this.charitiesService.charityUrl = 'http://localhost:8082/charities';
  }

  ngOnInit(): void {
    /*this.charity = new Charity();*/
    this.getCharity();
  }

  getCharity(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.charitiesService.getCharity(id)
      .subscribe(charity => {
        this.charity = charity;
        this.title = charity.title;
        this.image = charity.image;
        this.description = charity.description;
        this.donationRequired = charity.donationRequired;
        this.volunteersRequired = charity.volunteersRequired;
      });
  }

  editCharity() {
    this.charity.image = this.charityPath;
    this.charitiesService.updateCharity(this.charity.id, this.charity).subscribe(
      res => {
        console.log(res);
        this.isCharityEdited = true;
      }, error => {
        console.log(error);
      }
    );
    /*this.isCharityEdited = true;*/
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

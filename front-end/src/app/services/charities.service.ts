import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Charity} from '../charity';
import {User} from '../user';

@Injectable({
  providedIn: 'root'
})
export class CharitiesService {
  charityUrl: string;

  constructor(private http: HttpClient) {
  }

  public findAll(): Observable<Charity[]> {
    return this.http.get<Charity[]>(this.charityUrl);
  }

  public getCharity(id: number): Observable<Charity> {
    const url = `${this.charityUrl}/${id}`;
    return this.http.get<Charity>(url);
  }

  public deleteCharity(id: number) {
    const url = `${this.charityUrl}/${id}`;
    return this.http.delete(url);
  }

  public updateCharity(id: number, charity: Charity) {
    const url = `${this.charityUrl}/${id}`;
    return this.http.put(url, charity);
  }
}

import { Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import { Router } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Platform } from '@ionic/angular';
import { IonInfiniteScroll } from '@ionic/angular';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Location } from '@angular/common';

@Component({
  selector: 'app-search-apatient',
  templateUrl: './search-apatient.page.html',
  styleUrls: ['./search-apatient.page.scss'],
})
export class SearchAPatientPage{
  @ViewChild(IonInfiniteScroll) infiniteScroll: IonInfiniteScroll;
    public fname: string;
    public lname: string;
    public DOA: string;
    public gender: string;

  constructor(
    public route: Router,
    private platform: Platform,
    public navCtrl: NavController,
    private httpclient: HttpClient,
    private location: Location) {
  }

  start = () =>
  {

    const data = {
      firstname: this.fname,
      lastname: this.lname,
      gender: this.gender,
      doa: this.DOA
    }

    console.log(this.fname);
    console.log(this.lname);
    console.log(this.gender);
    console.log(this.DOA);

    this.route.navigate(['ViewAPatient'], {
      queryParams: data,
    })
  }
  logout = () => {
    this.route.navigateByUrl('AuthScreen');
  }

  ngOnInit() {
  }
}

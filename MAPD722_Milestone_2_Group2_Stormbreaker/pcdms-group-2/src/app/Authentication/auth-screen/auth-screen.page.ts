import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Platform } from '@ionic/angular';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Location } from '@angular/common';
import { IonInfiniteScroll } from '@ionic/angular';

@Component({
  selector: 'app-auth-screen',
  templateUrl: './auth-screen.page.html',
  styleUrls: ['./auth-screen.page.scss'],
})

export class AuthScreenPage implements OnInit, OnDestroy{
  @ViewChild(IonInfiniteScroll) infiniteScroll: IonInfiniteScroll;

  toggleInfiniteScroll() {
    this.infiniteScroll.disabled = !this.infiniteScroll.disabled;
  }

  public accessCode: string;
  public codes: boolean;
  public pass_code = [];

  httpHeader = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    public router: Router,
    private platform: Platform,
    public navCtrl: NavController,
    private httpclient: HttpClient,
    private location: Location) {
  }

  fetchData = () => {
    const url = ('https://wecare-heroku.herokuapp.com/')
    const sub_url = ('accesscode')
    fetch(url+sub_url)
        .then(response => response.json())
        .then((data) => {
            this.pass_code = data;
        })
        .catch((error) => {
        console.log(error);
    });
  }

  codeVerify = () => {
    this.codes = this.pass_code.some((val) => {
      return val.accessCode === this.accessCode;
    });
  }

  start = () =>
  {
    this.codeVerify();
    if(this.codes == true){
      this.platform.ready().then(() => {
        this.router.navigateByUrl('AuthVerified');
      });
    }
    else{
      this.platform.ready().then(() => {
        this.router.navigateByUrl('AuthDenied');
        this.ngOnDestroy();
      });
    }
  }

  ngOnInit() {
    this.fetchData();
  }

  ngOnDestroy(){
    this.accessCode = "";
  }
}

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

//   public accessCode: string;
//   public codes: boolean;
//   public pass_code = [];
//   public items = [
//     {
//         id: 1,
//         name: 'Karen, Jones | 04/02/1992 | 884-324-0930 | Pediatrics',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 2,
//         name: 'Kaylee, Matthews | 10/30/1999 | 884-098-9023 | Nursing',
//         pic: require('../pic.jpg')
//     },
//     {
//         id: 3,
//         name: 'Kendall, Alexander | 07/11/1942 | N/A | Immediate Care',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 4,
//         name: 'Briony, Morris | 27/73/4094 | 515-029-3856 | Nursing',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 5,
//         name: 'Freddie, Brown | 33/90/7254 | 909-630-2437 | Pediatrics',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 6,
//         name: 'Leonardo, Myers | 76/55/6304 | 093-450-8039 | Immediate Care',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 7,
//         name: 'Alan, Stewart | 06/26/1928 | 570-916-5367 | Pediatrics',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 8,
//         name: 'Lydia, Casey | 37/49/8523 | 683-281-9945 | Nursing',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 9,
//         name: 'Stella, Wright | 61/87/3391 | 792-256-0896 | Immediate Care',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 10,
//         name: 'George, Murray | 78/42/3681 | 905-242-3034 | Immediate Care',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 11,
//         name: 'Victoria, Evans | 82/29/0824 | 022-728-4438 | Nursing',
//         pic: require('./avatar.png'),
//     },
//     {
//         id: 12,
//         name: 'Amelia, Armstrong | 88/21/4432 | 590-851-6165 | Pediatrics',
//         pic: require('./avatar.png'),
//     },
// ];

//   httpHeader = {
//     headers: new HttpHeaders({ 'Content-Type': 'application/json' })
//   };

  constructor(
    public route: Router,
    private platform: Platform,
    public navCtrl: NavController,
    private httpclient: HttpClient,
    private location: Location) {

    // this.httpclient.get('https://www.reddit.com/r/gifs/new/.json?limit=10')
    // .map(res => res.json())
    // .subscribe(data => {
    //     this.pass_code = data.data.children;
    //   });

  }

//   fetchData = () => {

//     // return this.http.get('https://wecare-heroku.herokuapp.com/accesscode');

//     const url = ('https://wecare-heroku.herokuapp.com/accesscode')
//     fetch(url, {
//       headers: {
//       "Content-Type": "application/json",
//       "Origin": "https://localhost:8100/",
//       }
//     })
//         .then(response => response.json())
//         .then((data) => {
//             this.pass_code = data;
//             console.log(this.pass_code);
//         })
//         .catch((error) => {
//         console.log(error);
//     });
//     console.log(this.pass_code);
//   }

  // codeVerify = () => {
  //   this.codes = this.pass_code.some((val) => {
  //     console.log(val.accessCode);
  //     return val.accessCode === this.accessCode;
  //   });
  // }

  // toggleInfiniteScroll() {
  //   this.infiniteScroll.disabled = !this.infiniteScroll.disabled;
  // }

  start = () =>
  {
    // this.codeVerify();
    // if(this.accessCode == "yes"){
    //   this.platform.ready().then(() => {
        this.route.navigateByUrl('ViewAPatient');
    //   });
    // }
    // else{
    //   this.platform.ready().then(() => {
    //     this.router.navigateByUrl('AuthDenied');
    //     this.ngOnDestroy();
    //   });
    // }
  }
  logout = () => {
    this.route.navigateByUrl('AuthScreen');
  }

//   ngOnInit() {
//     this.fetchData();
//   }

//   ngOnDestroy(){
//     this.accessCode = "";
//   }

}

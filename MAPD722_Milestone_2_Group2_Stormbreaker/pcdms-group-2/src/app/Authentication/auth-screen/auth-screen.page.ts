import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Platform } from '@ionic/angular';

@Component({
  selector: 'app-auth-screen',
  templateUrl: './auth-screen.page.html',
  styleUrls: ['./auth-screen.page.scss'],
})
export class AuthScreenPage {

  public accessCode: string;
  constructor(public router: Router, private platform: Platform) {
  }

  start()
  {
    if(this.accessCode == "yes"){
      this.platform.ready().then(() => {
        this.router.navigateByUrl('AuthVerified');
      });
    }
    else{
      this.platform.ready().then(() => {
        this.router.navigateByUrl('AuthDenied');
      });
    }

  }

  ngOnInit() {
  }
}


// fetchData=()=>{
//   const url = 'https://wecare-heroku.herokuapp.com/accesscode'
//   fetch(url)
//       .then(response => response.json())
//       .then((data) => {
//           this.setState({
//               pass_code: data
//           })
//       })
//       .catch((error) => {
//       console.log(error)
//       .done();
//   });

import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';
import { Router } from '@angular/router';

@Component({
  selector: 'app-SplashScreen',
  templateUrl: 'SplashScreen.page.html',
  styleUrls: ['SplashScreen.page.scss']
})
export class SplashScreen implements OnInit{

  constructor(public route: Router) {
    setTimeout(()=>
    {
      this.route.navigateByUrl('AuthScreen');
    },3000);
  }

  ngOnInit() {}
}

import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common'

@Component({
  selector: 'app-auth-denied',
  templateUrl: './auth-denied.page.html',
  styleUrls: ['./auth-denied.page.scss'],
})
export class AuthDeniedPage implements OnInit {

  constructor(private route: Router, private location: Location) {
    setTimeout(() => {
      this.location.back();
    }, 3000);
  }
  ngOnInit() {
  }

}

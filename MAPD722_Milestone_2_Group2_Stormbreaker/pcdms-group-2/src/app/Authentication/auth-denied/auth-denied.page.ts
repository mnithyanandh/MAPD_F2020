import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-auth-denied',
  templateUrl: './auth-denied.page.html',
  styleUrls: ['./auth-denied.page.scss'],
})
export class AuthDeniedPage implements OnInit {

  constructor(private route: Router) {
    setTimeout(() => {
      this.route.navigateByUrl('AuthScreen');
    }, 3000);
  }
  ngOnInit() {
  }

}

import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-auth-verified',
  templateUrl: './auth-verified.page.html',
  styleUrls: ['./auth-verified.page.scss'],
})
export class AuthVerifiedPage {

  constructor(private route: Router) {
    setTimeout(() => {
      this.route.navigateByUrl('Tabs');
    }, 3000);
  }

  ngOnInit() {
  }

}

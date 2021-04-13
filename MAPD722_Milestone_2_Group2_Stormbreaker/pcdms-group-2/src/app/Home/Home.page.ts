import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { IonInfiniteScroll } from '@ionic/angular';
import { Component, ViewEncapsulation, ViewChild } from '@angular/core';

@Component({
  selector: 'app-Home',
  templateUrl: 'Home.page.html',
  styleUrls: ['Home.page.scss'],
  encapsulation: ViewEncapsulation.None
})
export class HomePage {
  @ViewChild(IonInfiniteScroll) infiniteScroll: IonInfiniteScroll;

  constructor(private route: Router, private location: Location) {}

  toggleInfiniteScroll() {
    this.infiniteScroll.disabled = !this.infiniteScroll.disabled;
  }

  logout(){
    this.route.navigateByUrl('AuthScreen');
  }

}

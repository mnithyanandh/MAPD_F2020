import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-apatient',
  templateUrl: './view-apatient.page.html',
  styleUrls: ['./view-apatient.page.scss'],
})
export class ViewAPatientPage implements OnInit {

  constructor(private route: Router, private location: Location) { }

  logout(){
    this.location.back();
  }

  ngOnInit() {
  }

}

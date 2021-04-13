import { Router } from '@angular/router';
import { Component, ViewChild } from '@angular/core';
import { IonInfiniteScroll } from '@ionic/angular';
import { Location } from '@angular/common';

@Component({
  selector: 'app-AddAPatient',
  templateUrl: 'AddAPatient.page.html',
  styleUrls: ['AddAPatient.page.scss']
})
export class AddAPatient {
  @ViewChild(IonInfiniteScroll) infiniteScroll: IonInfiniteScroll;

  public firstName: String;
  public efirstName: String;
  public lastName: String;
  public elastName: String;
  public econtactType: String;
  public month: Int16Array;
  public date: Int16Array;
  public year: Int16Array;
  public doa: Int16Array;
  public addressL1: String;
  public addressL2: String;
  public city: String;
  public province: String;
  public phoneno: Int16Array;
  public ephoneno: Int16Array;
  public height: Int16Array;
  public weight: Int16Array;
  public bloodp: String;
  public respiratoryr: String;
  public bloodoxy: String;
  public heartr: String;
  public preconditions: String;
  public symptoms: String;

  public gender: String;
  public medications: String;
  public xmedications: String;
  public allergies: String;
  public xallergies: String;
  public alcohol: String;

  constructor(private route: Router, private location: Location) {}

  toggleInfiniteScroll() {
    this.infiniteScroll.disabled = !this.infiniteScroll.disabled;
  }

  logout(){
    this.route.navigateByUrl('AuthScreen');
  }
}

import { Component, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Platform } from '@ionic/angular';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Location } from '@angular/common';
import { IonInfiniteScroll } from '@ionic/angular';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-apatient',
  templateUrl: './view-apatient.page.html',
  styleUrls: ['./view-apatient.page.scss'],
})


export class ViewAPatientPage implements OnInit {
  @ViewChild(IonInfiniteScroll) infiniteScroll: IonInfiniteScroll;

  public firstname: string;
  public efirstname: string;
  public lastname: string;
  public elastname: string;
  public econtactType: string;
  public month: string;
  public date: string;
  public year: string;
  public dob: string;
  public doa: string;
  public address: string;
  public phoneno: string;
  public ephoneno: string;
  public height: string;
  public weight: string;
  public bloodp: string;
  public respiratoryr: string;
  public bloodoxy: string;
  public heartr: string;
  public preconditions: string;
  public symptoms: string;

  public gender: string;
  public medications: string;
  public xmedications: string;
  public allergies: string;
  public xallergies: string;
  public alcohol: string;
  public tobacco: string;
  public currentCondition: string;

  public hasEpilepsy: string;
  public hasCaridacArrest: string;
  public hasHypertension: string;
  public hasCancer: string;
  public hasAsthma: string;
  public hasDiabetes: string;

  public hasFirstName: boolean;
  public hasLastName: boolean;
  public hasGender: boolean;
  public hasDOA: boolean;

  public patientrecord: any[];

  constructor(private route: Router, private location: Location, public activatedRoute : ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe((res)=>{
      this.firstname = res.firstname;
      this.lastname = res.lastname;
      this.gender = res.gender;
      this.doa = res.doa;
    });
   }

  toggleInfiniteScroll() {
    this.infiniteScroll.disabled = !this.infiniteScroll.disabled;
  }

  logout(){
    this.location.back();
  }

  fetchData = () => {
    const url = ('https://wecare-heroku.herokuapp.com/patients')
    const sub_url = ('patients/firstName')
    fetch(url)
        .then(response => response.json())
        .then((data) => {
            this.patientrecord = data;
            console.log(this.patientrecord);
        })
        .catch((error) => {
        console.log(error);
    });
   //this.verifyPatientFirstName();
  }

  verifyPatientFirstName = () => {
    this.hasFirstName = this.patientrecord.some((val) => {
      console.log(val.firstName);
      // this.gender = val.gender;
      // this.doa = val.doa;
      return val.firstName === this.firstname;
    });
    this.findPatient();
  }
  // verifyPatientLastName = () => {
  //   this.hasLastName = this.patient_record.some((val) => {
  //     return val.lastName === this.lastname;
  //   });
  // }

  findPatient() {
    if(this.hasFirstName == true){
      console.log(this.firstname);
      console.log(this.lastname);
      console.log(this.doa);
      console.log(this.dob);
      console.log(this.gender);
      console.log(this.phoneno);
      console.log(this.address);
      console.log(this.height);
      console.log(this.weight);
      console.log(this.bloodp);
      console.log(this.respiratoryr);
      console.log(this.bloodoxy);
      console.log(this.heartr);
      console.log(this.medications);
      console.log(this.xmedications);
      console.log(this.efirstname);
      console.log(this.elastname);
      console.log(this.econtactType);
      console.log(this.preconditions);
      console.log(this.symptoms);
      console.log(this.xallergies);
      console.log(this.alcohol);
      console.log(this.tobacco);
      console.log(this.currentCondition);
    }
    else {
      console.log("Nothing");
    }
  }

  ngOnInit() {
    this.fetchData();
    //this.verifyPatientLastName();
    this.findPatient();
  }

}

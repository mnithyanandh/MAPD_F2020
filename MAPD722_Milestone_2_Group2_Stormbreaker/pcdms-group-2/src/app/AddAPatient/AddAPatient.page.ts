import { Router } from '@angular/router';
import { Component, ViewChild, OnInit, OnDestroy } from '@angular/core';
import { IonInfiniteScroll } from '@ionic/angular';
import { Location } from '@angular/common';
import { FormBuilder, FormGroup } from "@angular/forms";
import { DatePipe } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
//import {RequestOptions, Request, RequestMethod} from '@angular/http';

@Component({
  selector: 'app-AddAPatient',
  templateUrl: 'AddAPatient.page.html',
  styleUrls: ['AddAPatient.page.scss'],
  providers: [DatePipe]
})
export class AddAPatient implements OnDestroy, OnInit {
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
  public addressL1: string;
  public addressL2: string;
  public city: string;
  public province: string;
  public zipcode: string;
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

  public form: FormGroup;
  public allOptionStateChecked = false;
  public allOptionStateIndeterminate = false;

  constructor(
    private route: Router,
    private location: Location,
    private datePipe: DatePipe,
    private httpclient: HttpClient,
    private formBuilder: FormBuilder) {}

  toggleInfiniteScroll = () => {
    this.infiniteScroll.disabled = !this.infiniteScroll.disabled;
  }

  ngOnInit(){
    this.form = this.formBuilder.group({
      all: false,
      Epilepsy: false,
      Cardiac: false,
      Hypertension: false,
      Cancer: false,
      Asthma: false,
      Diabetes: false
    });
  }

  public onAllChange(): void {
    const nextValue = this.allChecked() ? false : true;

    this.form.get("Epilepsy").patchValue(nextValue);
    this.form.get("Cardiac").patchValue(nextValue);
    this.form.get("Hypertension").patchValue(nextValue);
    this.form.get("Cancer").patchValue(nextValue);
    this.form.get("Asthma").patchValue(nextValue);
    this.form.get("Diabetes").patchValue(nextValue);
  }

  public onPreConditionsChange(): void {
    this.allOptionStateChecked = this.allChecked();
    this.allOptionStateIndeterminate = this.someChecked();

    this.form.get("all").patchValue(this.allOptionStateChecked);
  }

  private allChecked(): boolean {
    const EpilepsyValue = this.form.get("Epilepsy").value;
    const CardiacValue = this.form.get("Cardiac").value;
    const HypertensionValue = this.form.get("Hypertension").value;
    const CancerValue = this.form.get("Cancer").value;
    const AsthmaValue = this.form.get("Asthma").value;
    const DiabetesValue = this.form.get("Diabetes").value;

    return EpilepsyValue && CardiacValue && HypertensionValue && CancerValue && AsthmaValue && DiabetesValue;
  }

  private someChecked(): boolean {
    const EpilepsyValue = this.form.get("Epilepsy").value;
    const CardiacValue = this.form.get("Cardiac").value;
    const HypertensionValue = this.form.get("Hypertension").value;
    const CancerValue = this.form.get("Cancer").value;
    const AsthmaValue = this.form.get("Asthma").value;
    const DiabetesValue = this.form.get("Diabetes").value;

    return !this.allChecked() && (EpilepsyValue || CardiacValue || HypertensionValue || CancerValue || AsthmaValue || DiabetesValue);
  }

  submit = () => {
    this.checkHasDiseases();
    this.fetchData();
    //this.httpPost();
    this.route.navigateByUrl('Tabs/SearchAPatient');
  }

  checkHasDiseases = () => {
    if(this.form.get('Epilepsy').value == true){
      this.hasEpilepsy = "Epilepsy, ";
    }
    else{
      this.hasEpilepsy = "";
    }

    if(this.form.get('Cardiac').value == true){
      this.hasCaridacArrest = "Cardiac Arrest, ";
    }
    else{
      this.hasCaridacArrest = "";
    }

    if(this.form.get('Hypertension').value == true){
      this.hasHypertension = "Hypertension, ";
    }
    else{
      this.hasHypertension = "";
    }

    if(this.form.get('Cancer').value == true){
      this.hasCancer = "Cancer, ";
    }
    else{
      this.hasCancer = "";
    }

    if(this.form.get('Asthma').value == true){
      this.hasAsthma = "Asthma, ";
    }
    else{
      this.hasAsthma = "";
    }

    if(this.form.get('Diabetes').value == true){
      this.hasDiabetes = "Diabetes, ";
    }
    else{
      this.hasDiabetes = "";
    }
  }

  fetchData = () => {
    const Address = this.addressL1+', '+this.addressL2+', '+this.city+', '+this.province+' '+this.zipcode;
    this.dob = this.month+'/'+this.date+'/'+this.year;
    const patientConditions = this.hasEpilepsy+this.hasCaridacArrest+this.hasHypertension+this.hasCancer+this.hasAsthma+this.hasDiabetes+this.preconditions;
    //const doa = new Date();
    const data = {
      firstName: this.firstname,
      lastName: this.lastname,
      dateOfBirth: this.dob,
      dateOfAdmission: this.doa,
      gender: this.gender,
      address: Address,
      patientContact: "+1-"+this.phoneno,
      height: this.height+" cm",
      weight: this.weight+" kg",
      bloodPressure: this.bloodp,
      respiratoryRate: this.respiratoryr+"/min",
      bloodOxygenLevel: this.bloodoxy+"%",
      heartbeatRate: this.heartr+"bpm",
      currentlyOnMedication: this.medications,
      additionalMedications: this.xmedications,
      emergencyFirstName: this.efirstname,
      emergencyLastName: this.elastname,
      emergencyRelationship: this.econtactType,
      diseases: patientConditions,
      symptoms: this.symptoms,
      medicalAllergies: this.allergies,
      additionalAllergies: this.xallergies,
      consumeAlcohol: this.alcohol,
      consumeTobaccoOrSmoke: this.tobacco,
      condition: this.currentCondition
    };
    const url = ('https://wecare-heroku.herokuapp.com/patients');
    fetch(url,
    {
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    method: 'post',
    credentials: 'omit',
    body: JSON.stringify(data)
    })
    .then((response) => response.json())
    .catch((error) => {
    console.error('Error:', error);
    });
  }

// -------------- HTTP CLIENT CALLING -------------- //
// In the event Fetch API decides to take a vacation //
// ------------------------------------------------- //

  httpPost = () => {
    const Address = this.addressL1+', '+this.addressL2+', '+this.city+', '+this.province+' '+this.zipcode;
    this.dob = this.month+'/'+this.date+'/'+this.year;
    const doa = new Date();
    let data = {
      firstName: this.firstname,
      lastName: this.lastname,
      dateOfBirth: this.dob,
      dateOfAdmission: doa,
      gender: this.gender,
      address: Address,
      patientContact: "+1-"+this.phoneno,
      height: this.height+" cm",
      weight: this.weight+" kg",
      bloodPressure: this.bloodp+"/120",
      respiratoryRate: this.respiratoryr+"/min",
      bloodOxygenLevel: this.bloodoxy+"%",
      heartbeatRate: this.heartr+"bpm",
      currentlyOnMedication: this.medications,
      additionalMedications: this.xmedications,
      emergencyFirstName: this.efirstname,
      emergencyLastName: this.elastname,
      emergencyRelationship: this.econtactType,
      diseases: this.preconditions,
      symptoms: this.symptoms,
      medicalAllergies: this.allergies,
      additionalAllergies: this.xallergies,
      consumeAlcohol: this.alcohol,
      consumeTobaccoOrSmoke: this.tobacco,
      condition: this.currentCondition
    }

    let httpHeader = new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json'
   });

    let options = {
      headers: httpHeader
   }

    this.httpclient.post("https://wecare-heroku.herokuapp.com/patients", data, options)
    .subscribe(
      data => {
        console.log('Success', data);
      },
      error => {
        console.error('There was an error!', error);
      }
    )
  }

  reset = () => {
    window.location.reload();
  }

  logout = () => {
    this.route.navigateByUrl('AuthScreen');
  }

  ngOnDestroy() {
    location.reload();
  }
}

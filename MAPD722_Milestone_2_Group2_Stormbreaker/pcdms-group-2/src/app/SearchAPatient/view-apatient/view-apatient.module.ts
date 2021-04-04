import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ViewAPatientPageRoutingModule } from './view-apatient-routing.module';

import { ViewAPatientPage } from './view-apatient.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ViewAPatientPageRoutingModule
  ],
  declarations: [ViewAPatientPage]
})
export class ViewAPatientPageModule {}

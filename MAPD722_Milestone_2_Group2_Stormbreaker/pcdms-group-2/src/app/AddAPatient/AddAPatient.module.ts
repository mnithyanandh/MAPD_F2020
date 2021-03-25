import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AddAPatient } from './AddAPatient.page';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { AddAPatientRoutingModule } from './AddAPatient-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    ExploreContainerComponentModule,
    RouterModule.forChild([{ path: '', component: AddAPatient }]),
    AddAPatientRoutingModule,
  ],
  declarations: [AddAPatient]
})
export class AddAPatientModule {}

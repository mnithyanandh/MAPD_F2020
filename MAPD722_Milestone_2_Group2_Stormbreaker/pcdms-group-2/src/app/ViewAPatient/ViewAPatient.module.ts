import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ViewAPatient } from './ViewAPatient.page';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { ViewAPatientRoutingModule } from './ViewAPatient-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    ExploreContainerComponentModule,
    ViewAPatientRoutingModule
  ],
  declarations: [ViewAPatient]
})
export class ViewAPatientModule {}

import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SearchAPatient } from './SearchAPatient.page';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { SearchAPatientRoutingModule } from './SearchAPatient-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    ExploreContainerComponentModule,
    SearchAPatientRoutingModule
  ],
  declarations: [SearchAPatient]
})
export class SearchAPatientModule {}

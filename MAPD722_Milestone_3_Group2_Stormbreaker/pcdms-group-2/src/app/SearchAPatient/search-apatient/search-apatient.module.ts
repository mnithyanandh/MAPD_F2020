import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonicModule } from '@ionic/angular';

import { SearchAPatientPageRoutingModule } from './search-apatient-routing.module';
import { ExploreContainerComponentModule } from '../../explore-container/explore-container.module';

import { SearchAPatientPage } from './search-apatient.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ExploreContainerComponentModule,
    SearchAPatientPageRoutingModule
  ],
  declarations: [SearchAPatientPage]
})
export class SearchAPatientPageModule {}

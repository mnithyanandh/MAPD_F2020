import { IonicModule } from '@ionic/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActiveCases } from './ActiveCases.page';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { ActiveCasesRoutingModule } from './ActiveCases-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    ExploreContainerComponentModule,
    ActiveCasesRoutingModule
  ],
  declarations: [ActiveCases]
})
export class ActiveCasesModule {}

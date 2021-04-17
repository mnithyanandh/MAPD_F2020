import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ViewAPatientPage } from './view-apatient.page';

const routes: Routes = [
  {
    path: '',
    component: ViewAPatientPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ViewAPatientPageRoutingModule {}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewAPatient } from './ViewAPatient.page';

const routes: Routes = [
  {
    path: '',
    component: ViewAPatient,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ViewAPatientRoutingModule {}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAPatient } from './AddAPatient.page';

const routes: Routes = [
  {
    path: '',
    component: AddAPatient,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AddAPatientRoutingModule {}

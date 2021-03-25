import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchAPatient } from './SearchAPatient.page';

const routes: Routes = [
  {
    path: '',
    component: SearchAPatient,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SearchAPatientRoutingModule {}

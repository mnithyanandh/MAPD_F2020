import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SearchAPatientPage } from './search-apatient.page';

const routes: Routes = [
  {
    path: '',
    component: SearchAPatientPage,
    children: [
      {
        path: 'ViewAPatient',
        loadChildren: () => import('../view-apatient/view-apatient.module').then(m => m.ViewAPatientPageModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SearchAPatientPageRoutingModule {}

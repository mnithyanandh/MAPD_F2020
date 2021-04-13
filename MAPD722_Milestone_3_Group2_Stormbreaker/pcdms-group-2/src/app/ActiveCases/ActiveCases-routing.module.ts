import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActiveCases } from './ActiveCases.page';

const routes: Routes = [
  {
    path: '',
    component: ActiveCases,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ActiveCasesRoutingModule {}

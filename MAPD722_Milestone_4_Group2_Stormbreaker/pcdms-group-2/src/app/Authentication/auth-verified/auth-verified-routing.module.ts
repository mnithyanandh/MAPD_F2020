import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthVerifiedPage } from './auth-verified.page';

const routes: Routes = [
  {
    path: '',
    component: AuthVerifiedPage,
  },
  {
    path: 'Tabs',
    loadChildren: () => import('../../Tabs/tabs.module').then(m => m.TabsPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthVerifiedPageRoutingModule {}

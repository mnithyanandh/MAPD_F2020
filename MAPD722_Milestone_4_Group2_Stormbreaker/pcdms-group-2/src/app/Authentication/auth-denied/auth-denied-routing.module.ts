import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AuthDeniedPage } from './auth-denied.page';

const routes: Routes = [
  {
    path: '',
    component: AuthDeniedPage,
  },
  {
    path: 'AuthScreen',
    loadChildren: () => import('../auth-screen/auth-screen.module').then(m => m.AuthScreenPageModule)
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthDeniedPageRoutingModule {}

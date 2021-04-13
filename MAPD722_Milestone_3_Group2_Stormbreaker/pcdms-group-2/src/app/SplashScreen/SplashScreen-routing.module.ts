import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SplashScreen } from './SplashScreen.page';

const routes: Routes = [
  {
    path: '',
    component: SplashScreen,
  },
  {
    path: 'AuthScreen',
    loadChildren: () => import('../Authentication/auth-screen/auth-screen.module').then( m => m.AuthScreenPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SplashScreenRoutingModule {}

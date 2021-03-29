import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SplashScreen } from './SplashScreen.page';

const routes: Routes = [
  {
    path: '',
    component: SplashScreen,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SplashScreenRoutingModule {}

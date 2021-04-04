import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'Splash',
    loadChildren: () => import('./SplashScreen/SplashScreen.module').then(m => m.SplashScreenModule)
  },
  {
    path: 'AuthScreen',
    loadChildren: () => import('./Authentication/auth-screen/auth-screen.module').then( m => m.AuthScreenPageModule)
  },
  {
    path: 'AuthVerified',
    loadChildren: () => import('./Authentication/auth-verified/auth-verified.module').then( m => m.AuthVerifiedPageModule)
  },
  {
    path: 'AuthDenied',
    loadChildren: () => import('./Authentication/auth-denied/auth-denied.module').then( m => m.AuthDeniedPageModule)
  },
  {
    path: 'Tabs',
    loadChildren: () => import('./Tabs/tabs.module').then(m => m.TabsPageModule)
  },
];
@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}

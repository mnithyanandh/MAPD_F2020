import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: 'tabs',
    component: TabsPage,
    children: [
      {
        path: 'Home',
        loadChildren: () => import('../Home/Home.module').then(m => m.HomePageModule)
      },
      {
        path: 'SearchAPatient',
        loadChildren: () => import('../SearchAPatient/SearchAPatient.module').then(m => m.SearchAPatientModule)
      },
      {
        path: 'AddAPatient',
        loadChildren: () => import('../AddAPatient/AddAPatient.module').then(m => m.AddAPatientModule)
      },
      {
        path: 'ActiveCases',
        loadChildren: () => import('../ActiveCases/ActiveCases.module').then(m => m.ActiveCasesModule)
      },
      {
        path: '',
        redirectTo: '/tabs/Home',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/tabs/Home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class TabsPageRoutingModule {}

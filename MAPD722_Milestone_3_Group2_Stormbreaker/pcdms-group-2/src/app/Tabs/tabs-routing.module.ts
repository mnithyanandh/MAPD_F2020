import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TabsPage } from './tabs.page';

const routes: Routes = [
  {
    path: '',
    component: TabsPage,
    children: [
      {
        path: 'Home',
        loadChildren: () => import('../Home/Home.module').then(m => m.HomePageModule)
      },
      {
        path: 'SearchAPatient',
        loadChildren: () => import('../SearchAPatient/search-apatient/search-apatient.module').then(m => m.SearchAPatientPageModule)
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
        redirectTo: '/Tabs/Home',
        pathMatch: 'full'
      }
    ]
  },
  {
    path: '',
    redirectTo: '/Tabs/Home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
})
export class TabsPageRoutingModule {}

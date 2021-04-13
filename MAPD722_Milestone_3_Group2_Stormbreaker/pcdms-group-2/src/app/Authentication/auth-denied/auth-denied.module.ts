import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { AuthDeniedPageRoutingModule } from './auth-denied-routing.module';

import { AuthDeniedPage } from './auth-denied.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    AuthDeniedPageRoutingModule
  ],
  declarations: [AuthDeniedPage]
})
export class AuthDeniedPageModule {}

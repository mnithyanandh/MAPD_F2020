import { IonicModule } from '@ionic/angular';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SplashScreen } from './SplashScreen.page';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';
import { SplashScreenRoutingModule } from './SplashScreen-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    ExploreContainerComponentModule,
    SplashScreenRoutingModule
  ],
  declarations: [SplashScreen]
})
export class SplashScreenModule {}

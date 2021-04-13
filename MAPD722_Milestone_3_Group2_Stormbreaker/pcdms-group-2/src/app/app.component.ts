import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { Platform } from '@ionic/angular';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {

  constructor(private platform: Platform, public router: Router)
  {
    this.start();
  }

  start()
  {
    this.platform.ready().then(() => {
      // change back to "Splash" once finalized
      this.router.navigateByUrl('Splash');
    });
  }
}

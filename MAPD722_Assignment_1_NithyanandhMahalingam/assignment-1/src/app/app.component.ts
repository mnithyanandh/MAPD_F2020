import { Component } from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [
    { title: 'Calculator', url: '/main/Pay Calulator', icon: 'calculator' },
    { title: 'About', url: '/folder/About', icon: 'information-circle' }
  ];
  public labels = ['Quit'];
  constructor() {}
}

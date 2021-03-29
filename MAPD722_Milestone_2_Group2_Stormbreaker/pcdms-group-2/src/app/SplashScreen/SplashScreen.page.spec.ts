import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { SplashScreen } from './SplashScreen.page';

describe('SplashScreen', () => {
  let component: SplashScreen;
  let fixture: ComponentFixture<SplashScreen>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [SplashScreen],
      imports: [IonicModule.forRoot(), ExploreContainerComponentModule]
    }).compileComponents();

    fixture = TestBed.createComponent(SplashScreen);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

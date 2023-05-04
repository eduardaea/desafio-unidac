import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrekkerComponent } from './brekker.component';

describe('BrekkerComponent', () => {
  let component: BrekkerComponent;
  let fixture: ComponentFixture<BrekkerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrekkerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BrekkerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

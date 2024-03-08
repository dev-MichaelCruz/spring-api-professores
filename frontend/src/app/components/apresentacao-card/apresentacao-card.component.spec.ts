import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApresentacaoCardComponent } from './apresentacao-card.component';

describe('ApresentacaoCardComponent', () => {
  let component: ApresentacaoCardComponent;
  let fixture: ComponentFixture<ApresentacaoCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApresentacaoCardComponent]
    });
    fixture = TestBed.createComponent(ApresentacaoCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPlaylistComponent } from './list-playlist.component';

describe('ListPlaylistComponent', () => {
  let component: ListPlaylistComponent;
  let fixture: ComponentFixture<ListPlaylistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListPlaylistComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListPlaylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

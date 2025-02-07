import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private playlistData: any;

  setPlaylistData(data: any): void {
    this.playlistData = data;
  }

  getPlaylistData(): any {
    return this.playlistData;
  }
}
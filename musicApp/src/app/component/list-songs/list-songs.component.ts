import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { SharedService } from '../../guard/shared/shared.service';
import { AuthService } from '../../guard/auth.service';

@Component({
  selector: 'app-list-songs',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list-songs.component.html',
  styleUrls: ['./list-songs.component.css']
})
export class ListSongsComponent implements OnInit {
  playlist: any;

  constructor(
    private router: Router, 
    private sharedService: SharedService,
     
  ) {}

  ngOnInit(): void {
    this.playlist = this.sharedService.getPlaylistData(); // Obtén los datos de la playlist desde el servicio compartido
    console.log("playlist",this.playlist);
    
    if (!this.playlist) {
      this.router.navigate(['/list-playlist']); // Redirige si no hay datos de la playlist
    }
  }

  goBack() {
    this.router.navigate(['/list-playlist']); 
  }
}
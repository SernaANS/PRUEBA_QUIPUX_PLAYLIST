import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlaylistService } from '../../guard/playlist.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AuthService } from '../../guard/auth.service';
import { SharedService } from '../../guard/shared/shared.service';

@Component({
  selector: 'app-list-playlist',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './list-playlist.component.html',
  styleUrls: ['./list-playlist.component.css']
})
export class ListPlaylistComponent implements OnInit {
  
  playlists: any[] = [];
  searchTerm: string = '';
  filteredPlaylists: any[] = []; 

  constructor(private playlistService: PlaylistService,
    private authService: AuthService, 
    private sharedService: SharedService,
    private router: Router) {}

  ngOnInit(): void {
    this.getPlaylists();
  }

  getPlaylists(): void {
    if (this.authService.getToken()) {
      this.playlistService.getPlaylists().subscribe({
        next: (data) => {
          this.playlists = data;
          this.filteredPlaylists = this.playlists; // Inicializa filteredPlaylists con los datos obtenidos
        },
        error: (error) => {
          console.error('Error fetching playlists', error);
        }
      });
    } else {
      this.router.navigate(['/login']);
    }
  }

  filterPlaylists(): void {
    if (this.searchTerm) {
      this.filteredPlaylists = this.playlists.filter(playlist =>
        playlist.name.toLowerCase().includes(this.searchTerm.toLowerCase())
      );
    } else {
      this.filteredPlaylists = this.playlists;
    }
  }

  goToListSongs(playlist: any): void {
    this.sharedService.setPlaylistData(playlist); // Guarda los datos en el servicio compartido
    this.router.navigate(['/list-songs']);
  }

  goToFormPlaylist(): void {
    if (this.authService.isAuthenticated()) {
      this.router.navigate(['/form-playlist']);
    } else {
      this.router.navigate(['/login']);
    }
  }

  deletePlaylist(id: string): void {
    if (this.authService.isAuthenticated()) {
      this.playlistService.deletePlaylist(id).subscribe({
        next: () => {
          this.playlists = this.playlists.filter(playlist => playlist.id !== id);
          this.filteredPlaylists = this.playlists; // Actualiza filteredPlaylists después de eliminar
        },
        error: (error) => {
          console.error('Error deleting playlist', error);
        }
      });
    } else {
      this.router.navigate(['/login']);
    }
  }

  clearSearch(): void {
    this.searchTerm = '';
    this.filteredPlaylists = this.playlists;
  }
}
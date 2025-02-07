import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PlayList } from '../models/PlayList';


@Injectable({
  providedIn: 'root'
})
export class PlaylistService {
  private apiUrl = 'http://localhost:8080/api/quipux-playlist'; // Reemplaza con la URL de tu API

  constructor(private http: HttpClient) { }

  getPlaylists(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/lists`,{ headers : this.getHeaders() });
  }

  getPlaylistByName(name: string): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/lists/${name}`, { headers : this.getHeaders() });
  }

  createPlaylist(playlist: PlayList): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/lists`, playlist, { headers : this.getHeaders() });
  }

  deletePlaylist(name: string): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/lists/${name}`, { headers : this.getHeaders() });
  }


  private getHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');;
    const headers = token ? new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    }) : new HttpHeaders();
  
    return headers;
  }
  
}
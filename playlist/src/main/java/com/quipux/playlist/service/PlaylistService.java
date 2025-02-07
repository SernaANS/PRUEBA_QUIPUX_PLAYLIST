package com.quipux.playlist.service;

import com.quipux.playlist.models.Playlist;

import java.util.List;

public interface PlaylistService {

    Playlist  save(Playlist playlist);

    List<Playlist> getAllPlaylists();

    Playlist getPlaylistByName(String listName);

    void deletePlaylist(String listName);
}

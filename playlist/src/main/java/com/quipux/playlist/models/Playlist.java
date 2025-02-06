package com.quipux.playlist.models;

import com.quipux.playlist.controller.request.SongRequest;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private String description;
    private List<Song> song = new ArrayList<>();
}

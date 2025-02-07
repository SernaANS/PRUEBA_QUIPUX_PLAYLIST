package com.quipux.playlist.models;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Playlist {
    private String name;
    private String description;
    private List<Song> songs = new ArrayList<>();
}

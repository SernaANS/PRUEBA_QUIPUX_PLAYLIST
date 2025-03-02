package com.quipux.playlist.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    private String title;

    private String artist;

    private String album;

    private String releaseYear;

    private String genre;
}

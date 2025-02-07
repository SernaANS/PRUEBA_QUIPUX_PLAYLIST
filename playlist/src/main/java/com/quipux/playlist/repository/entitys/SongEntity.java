package com.quipux.playlist.repository.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String album;
    private String releaseYear;
    private String genre;

    @JsonIgnore
    @ManyToMany(mappedBy = "songs")
    private List<PlaylistEntity> playlists = new ArrayList<>();
}

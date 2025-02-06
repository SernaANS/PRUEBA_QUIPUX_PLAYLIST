package com.quipux.playlist.repository.entitys;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    private String description;

    @JoinTable(name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns =  @JoinColumn(name = "song_id"))
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<SongEntity> songs;
}

package com.quipux.playlist.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SongResponse {
    @JsonProperty("titulo")
    private String title;

    @JsonProperty("artista")
    private String artist;

    @JsonProperty("album")
    private String album;

    @JsonProperty("anno")
    private String releaseYear;

    @JsonProperty("genero")
    private String genre;
}

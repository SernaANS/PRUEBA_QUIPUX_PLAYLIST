package com.quipux.playlist.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SongRequest {
    @NotNull
    @JsonProperty("titulo")
    private String title;

    @NotNull
    @JsonProperty("artista")
    private String artist;

    @NotNull
    @JsonProperty("album")
    private String album;

    @NotNull
    @JsonProperty("anno")
    private String releaseYear;

    @NotNull
    @JsonProperty("genero")
    private String genre;
}

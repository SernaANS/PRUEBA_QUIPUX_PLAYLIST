package com.quipux.playlist.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlaylistRequest {

    @NotNull
    @JsonProperty("nombre")
    private String name;

    @NotNull
    @JsonProperty("descripcion")
    private String description;

    @NotNull
    @JsonProperty("canciones")
    private List<@Valid SongRequest> songs = new ArrayList<>();

}
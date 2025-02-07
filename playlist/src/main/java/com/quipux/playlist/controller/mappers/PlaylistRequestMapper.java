package com.quipux.playlist.controller.mappers;

import com.quipux.playlist.controller.request.PlaylistRequest;
import com.quipux.playlist.controller.response.PlaylistResponse;
import com.quipux.playlist.models.Playlist;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface PlaylistRequestMapper {
    PlaylistResponse toResponse(Playlist model);
    List<PlaylistResponse> toResponse(List<Playlist> model);
    Playlist toModel(PlaylistRequest playlist);
}

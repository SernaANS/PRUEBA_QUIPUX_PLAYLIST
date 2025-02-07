package com.quipux.playlist.controller.mappers;

import com.quipux.playlist.controller.request.SongRequest;
import com.quipux.playlist.controller.response.SongResponse;
import com.quipux.playlist.models.Song;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface SongRequestMapper {
    SongResponse toResponse (Song song);
    List<SongResponse> toResponse(List<Song> song);


    Song toDomain(SongRequest request);
    List<Song> toDomain(List<SongRequest> request);


}

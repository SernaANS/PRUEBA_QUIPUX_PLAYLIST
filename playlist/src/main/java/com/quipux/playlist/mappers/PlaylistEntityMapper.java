package com.quipux.playlist.mappers;

import com.quipux.playlist.models.Playlist;
import com.quipux.playlist.repository.entitys.PlaylistEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface PlaylistEntityMapper {
    Playlist toDomain(PlaylistEntity entity);
    List<Playlist> toDomain(List<PlaylistEntity> entity);

    PlaylistEntity toEntity(Playlist model);
    List<PlaylistEntity> toEntity(List<Playlist> model);

}

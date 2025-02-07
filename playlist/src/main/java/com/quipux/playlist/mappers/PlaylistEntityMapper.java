package com.quipux.playlist.mappers;

import com.quipux.playlist.models.Playlist;
import com.quipux.playlist.repository.entitys.PlaylistEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface PlaylistEntityMapper {
    Playlist toDomain(PlaylistEntity model);
    List<Playlist> toDomain(List<PlaylistEntity> model);

    PlaylistEntity toEntity(Playlist entity);
}

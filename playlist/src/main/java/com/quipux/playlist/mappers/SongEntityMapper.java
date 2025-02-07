package com.quipux.playlist.mappers;

import com.quipux.playlist.models.Song;
import com.quipux.playlist.repository.entitys.SongEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SongEntityMapper {

    SongEntity toEntity(Song model);

    List<SongEntity> toEntity(List<Song> model);

    List<Song> toModel (List<SongEntity> entity);
    Song toModel (SongEntity entity);

}
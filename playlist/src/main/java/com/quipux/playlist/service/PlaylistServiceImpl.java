package com.quipux.playlist.service;

import com.quipux.playlist.configs.exceptions.BadNamePlaylistException;
import com.quipux.playlist.configs.exceptions.NotFoundPlaylistException;
import com.quipux.playlist.mappers.PlaylistEntityMapper;
import com.quipux.playlist.mappers.SongEntityMapper;
import com.quipux.playlist.models.Playlist;
import com.quipux.playlist.repository.PlaylistRepository;
import com.quipux.playlist.repository.SongRepository;
import com.quipux.playlist.repository.entitys.PlaylistEntity;
import com.quipux.playlist.repository.entitys.SongEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl implements PlaylistService{

    PlaylistRepository playlistRepository;
    SongRepository songRepository;

    PlaylistEntityMapper palylistMapper;

    SongEntityMapper songEntityMapper;

    @Override
    public Playlist save(Playlist playlist) {
        playlistRepository.findByName(playlist.getName())
                .ifPresent(p -> { throw new BadNamePlaylistException("Ya existe una lista con ese nombre"); });

        List<SongEntity> songsSends = songEntityMapper.toEntity(playlist.getSongs());
        List<SongEntity> existingSongs = songRepository.findByTitleIn(songsSends.stream().map(SongEntity::getTitle).toList());

        List<SongEntity> songsToSave = songsSends.stream()
                .filter(song ->
                        existingSongs.stream().noneMatch(s -> s.getTitle().equals(song.getTitle())))
                .toList();

        List<SongEntity> songsSaved=songRepository.saveAll(songsToSave);

        List<SongEntity> allSongs = Stream.concat(existingSongs.stream(), songsSaved.stream())
                .collect(Collectors.toList());


        PlaylistEntity playlistToSave = palylistMapper.toEntity(playlist);
        playlistToSave.setSongs(allSongs);

        return palylistMapper.toDomain(
                playlistRepository.save(playlistToSave));
    }

    @Override
    public List<Playlist> getAllPlaylists() {
        return palylistMapper.toDomain(playlistRepository.findAll()) ;
    }

    @Override
    public Playlist getPlaylistByName(String listName) {
        return palylistMapper.toDomain(
                playlistRepository.findByName(listName)
                        .orElseThrow(()-> new NotFoundPlaylistException("Nombre de la lista no válido"))
        );
    }

    @Override
    public void deletePlaylist(String listName) {
        PlaylistEntity playlist=playlistRepository.findByName(listName)
                .orElseThrow(()-> new NotFoundPlaylistException("Nombre de la lista no válido"));
        playlistRepository.deleteById(playlist.getId());
    }
}

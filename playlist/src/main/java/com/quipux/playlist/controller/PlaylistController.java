package com.quipux.playlist.controller;

import com.quipux.playlist.controller.mappers.PlaylistRequestMapper;
import com.quipux.playlist.controller.request.PlaylistRequest;
import com.quipux.playlist.controller.response.PlaylistResponse;
import com.quipux.playlist.service.PlaylistService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("${request-mapping.controller.playlist}")
@RestController
@AllArgsConstructor
public class PlaylistController {

    private PlaylistService playlistService;

    private PlaylistRequestMapper playlistRequestMapper;

    @PostMapping
    public ResponseEntity<PlaylistResponse>  savePlaylist(@RequestBody @Valid PlaylistRequest playListRequest){
        return new ResponseEntity<>(
                playlistRequestMapper.toResponse(
                        playlistService.save(
                                playlistRequestMapper.toModel(playListRequest)))
                ,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PlaylistResponse>> getAll(){
        return ResponseEntity.ok(
                playlistRequestMapper.toResponse(
                        playlistService.getAllPlaylists())
        );
    }

    @GetMapping("/{listName}")
    public ResponseEntity<PlaylistResponse>  getByName(@PathVariable String listName){
        return ResponseEntity.ok(
                playlistRequestMapper.toResponse(playlistService.getPlaylistByName(listName)));
    }

    @DeleteMapping("/{listName}")
    public ResponseEntity<Void>  delete(@PathVariable String listName){
        playlistService.deletePlaylist(listName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

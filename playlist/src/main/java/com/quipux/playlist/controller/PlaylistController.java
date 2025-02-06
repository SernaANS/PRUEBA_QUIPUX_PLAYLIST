package com.quipux.playlist.controller;

import com.quipux.playlist.controller.request.PlaylistRequest;
import com.quipux.playlist.service.PlaylistService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("${request-mapping.controller.playlist}")
@RestController
@AllArgsConstructor
public class PlaylistController {

    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Object>  savePlaylist(@RequestBody @Valid PlaylistRequest playListRequest){

        playlistService.save(playlistService);

        return new ResponseEntity<>(null,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        //Sernice
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }
    @GetMapping("/{listName}")
    public ResponseEntity<Object>  getByName(@PathVariable String listName){
        //Service
        return ResponseEntity.ok(playlistService.getPlaylistByName(listName));
    }

    @DeleteMapping("/{listName}")
    public ResponseEntity<Void>  delete(@PathVariable String listName){
        playlistService.deletePlaylist(listName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

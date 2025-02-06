package com.quipux.playlist.controller;

import com.quipux.playlist.controller.request.PlaylistRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("${request-mapping.controller.playlist}")
@RestController
public class PlaylistController {


    @PostMapping
    public ResponseEntity<Object>  savePlaylist(@RequestBody @Valid PlaylistRequest playListRequest){
        //Sernice
        return new ResponseEntity<>(null,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Object> getAll(){
        //Sernice
        return ResponseEntity.ok(null);
    }
    @GetMapping("/{listName}")
    public ResponseEntity<Object>  getByName(@PathVariable String listName){
        //Service
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{listName}")
    public ResponseEntity<Void>  delete(@PathVariable String listName){
        //Sernice
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

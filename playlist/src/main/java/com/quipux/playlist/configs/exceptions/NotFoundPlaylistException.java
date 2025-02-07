package com.quipux.playlist.configs.exceptions;

public class NotFoundPlaylistException extends RuntimeException {
    public NotFoundPlaylistException(String message) {
        super(message);
    }
}

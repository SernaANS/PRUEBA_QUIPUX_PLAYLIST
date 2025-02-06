package com.quipux.playlist.configs.exceptions;

import com.quipux.playlist.controller.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(BadNamePlaylistException.class)
    public ErrorResponse handleBadNameException(BadNamePlaylistException exception) {
        exception.printStackTrace();
        return new ErrorResponse("BAD_NAME", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(NotFoundPlaylistException.class)
    public ErrorResponse handleNodFoundException(NotFoundPlaylistException exception) {
        exception.printStackTrace();
        return new ErrorResponse("NOT_FOUND", exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception exception) {
        exception.printStackTrace();
        return new ErrorResponse("500", exception.getMessage());
    }
}

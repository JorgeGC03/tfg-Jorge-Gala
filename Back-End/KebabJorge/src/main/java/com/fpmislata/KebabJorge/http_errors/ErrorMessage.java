package com.fpmislata.KebabJorge.http_errors;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ToString
public class ErrorMessage {

    private final String message;
    private final int code;

    public ErrorMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ErrorMessage badRequest(HttpMessageNotReadableException exception) {
        return new ErrorMessage("Invalid request body", HttpStatus.BAD_REQUEST.value());
    }

}

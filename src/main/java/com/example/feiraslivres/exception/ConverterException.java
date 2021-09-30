package com.example.feiraslivres.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "An error occurred while converting the payload.")
public class ConverterException extends RuntimeException{
}

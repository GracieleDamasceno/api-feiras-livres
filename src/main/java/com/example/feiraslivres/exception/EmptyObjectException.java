package com.example.feiraslivres.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "The conversion of payload resulted in a empty entity.")
public class EmptyObjectException extends RuntimeException{
}

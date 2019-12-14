package com.crud.tasks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Id is invalid")
public class TaskNotFoundException extends RuntimeException{
}

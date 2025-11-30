package org.example.catsgram.controller;

import org.example.catsgram.exception.*;
import org.example.catsgram.service.PostService;
import org.example.catsgram.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = {UserService.class,PostService.class})
public class ExceptionForUsersNPosts  {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponce incorrectParam(InCorrectaParamException e){
        return new ErrorResponce((e.getMessage()));
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponce userAlreadyExist(AlreadyExistException e){
        return new ErrorResponce((e.getMessage()));
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponce invalidEmail(InvalidParam e){
        return new ErrorResponce((e.getMessage()));
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponce notFounded(NotFoundedException e){
        return new ErrorResponce((e.getMessage()));
    }
}

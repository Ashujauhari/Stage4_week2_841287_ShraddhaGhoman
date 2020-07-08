package com.cognizant.favorite.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Favorite List Empty")
public class FavoritesEmptyException extends Exception {

}

package com.appian.cards.exception;

/**
 * Created by Naveen on 10/14/17.
 * Exception class for calling draw on a empty deck.
 */
public class EmptyDeckException extends RuntimeException {

    public EmptyDeckException(String message){
        super(message);
    }

}

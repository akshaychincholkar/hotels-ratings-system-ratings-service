package com.game.reviews.microservice.exceptions;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(){
        super("Review not found!");
    }
    public ReviewNotFoundException(String id) {
        super("Review not found with ID: "+id);
    }
}

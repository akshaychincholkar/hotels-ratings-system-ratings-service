package com.game.reviews.microservice.services;

import com.game.reviews.microservice.entities.Ratings;

import java.util.List;

public interface RatingService {
    Ratings saveReview(Ratings ratings);
    Ratings getReview(String id);
    List<Ratings> getAllReviews();
    Ratings updateReview(Ratings ratings);
    Ratings deleteReview(String id);

}

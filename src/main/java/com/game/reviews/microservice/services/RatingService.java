package com.game.reviews.microservice.services;

import com.game.reviews.microservice.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating saveReview(Rating rating);
    Rating getReview(String id);
    List<Rating> getAllReviews();
    Rating updateReview(Rating rating);
    Rating deleteReview(String id);
    List<Rating> getRatingsByUserId(String userId);
    List<Rating> getRatingsByHotelId(String hotelId);

}

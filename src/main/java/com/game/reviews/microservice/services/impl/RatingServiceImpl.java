package com.game.reviews.microservice.services.impl;

import com.game.reviews.microservice.entities.Rating;
import com.game.reviews.microservice.exceptions.ReviewNotFoundException;
import com.game.reviews.microservice.repositories.RatingRepository;
import com.game.reviews.microservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating saveReview(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getReview(String id) {
        return ratingRepository.findById(id).orElseThrow(()->new ReviewNotFoundException(id));
    }

    @Override
    public List<Rating> getAllReviews() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating updateReview(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating deleteReview(String id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(()->new ReviewNotFoundException(id));
        ratingRepository.deleteById(id);
        return rating;
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}

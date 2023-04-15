package com.game.reviews.microservice.services.impl;

import com.game.reviews.microservice.entities.Ratings;
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
    public Ratings saveReview(Ratings ratings) {
        return ratingRepository.save(ratings);
    }

    @Override
    public Ratings getReview(String id) {
        return ratingRepository.findById(id).orElseThrow(()->new ReviewNotFoundException(id));
    }

    @Override
    public List<Ratings> getAllReviews() {
        return ratingRepository.findAll();
    }

    @Override
    public Ratings updateReview(Ratings ratings) {
        return ratingRepository.save(ratings);
    }

    @Override
    public Ratings deleteReview(String id) {
        Ratings ratings = ratingRepository.findById(id).orElseThrow(()->new ReviewNotFoundException(id));
        ratingRepository.deleteById(id);
        return ratings;
    }
}

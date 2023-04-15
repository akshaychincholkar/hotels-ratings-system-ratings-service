package com.game.reviews.microservice.repositories;

import com.game.reviews.microservice.entities.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RatingRepository extends MongoRepository<Ratings,String> {
}

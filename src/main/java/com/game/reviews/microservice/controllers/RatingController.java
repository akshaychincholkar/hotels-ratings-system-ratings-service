package com.game.reviews.microservice.controllers;

import com.game.reviews.microservice.entities.Ratings;
import com.game.reviews.microservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Ratings> createRating(@RequestBody Ratings rating){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.saveReview(rating));
    }
    @GetMapping("/{rating-id}")
    public ResponseEntity<Ratings> getRating(@PathVariable ("rating-id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getReview(id));
    }

    @GetMapping
    public ResponseEntity<List<Ratings>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getAllReviews());
    }

    @PutMapping
    public ResponseEntity<Ratings> updateRating(@RequestBody Ratings rating){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.updateReview(rating));
    }
    @DeleteMapping("/{rating-id}")
    public ResponseEntity<Ratings> deleteRating(@PathVariable ("rating-id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.deleteReview(id));
    }
}

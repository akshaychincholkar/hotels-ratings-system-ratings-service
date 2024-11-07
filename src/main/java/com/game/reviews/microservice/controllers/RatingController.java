package com.game.reviews.microservice.controllers;

import com.game.reviews.microservice.entities.Rating;
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
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.saveReview(rating));
    }
    @GetMapping("/{rating-id}")
    public ResponseEntity<Rating> getRating(@PathVariable ("rating-id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getReview(id));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getAllReviews());
    }

    @PutMapping
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.updateReview(rating));
    }
    @DeleteMapping("/{rating-id}")
    public ResponseEntity<Rating> deleteRating(@PathVariable ("rating-id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.deleteReview(id));
    }
    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<Rating>> getUserRatings(@PathVariable("user-id") String userId){
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getRatingsByUserId(userId));
    }
    @GetMapping("/hotel/{hotel-id}")
    public ResponseEntity<List<Rating>> getHotelRatings(@PathVariable("hotel-id") String hotelId){
        return ResponseEntity.status(HttpStatus.FOUND).body(ratingService.getRatingsByHotelId(hotelId));
    }
}

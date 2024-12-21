package com.Project.FirstProject.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
        List<Review> reviews = reviewService.getAllReview(companyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> insertReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isReviewSaved = reviewService.insertReview(companyId, review);
        if(isReviewSaved){return new ResponseEntity<>("Review inserted!",HttpStatus.OK);}
        return new ResponseEntity<>("Review Not Saved!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        Review review = reviewService.getReviewById(companyId, reviewId);
        if(review != null){return new ResponseEntity<>(review, HttpStatus.OK);}
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId, @PathVariable Long reviewId,
                                                   @RequestBody Review review){
        boolean isUpdated = reviewService.updateReviewById(companyId, reviewId, review);
        if(isUpdated){return new ResponseEntity<>("Review Updated!", HttpStatus.OK);}
        return new ResponseEntity<>("Review not updated!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isDeleted = reviewService.deleteReviewById(companyId, reviewId);
        if(isDeleted){
            return new ResponseEntity<>("Review Deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not found!", HttpStatus.NOT_FOUND);
    }

}


package com.Project.FirstProject.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReview(Long id);

    boolean insertReview(Long companyId, Review review);

    Review getReviewById(Long companyId, Long reviewId);

    boolean updateReviewById(Long companyId, Long reviewId, Review review);

    boolean deleteReviewById(Long companyId, Long reviewId);
}

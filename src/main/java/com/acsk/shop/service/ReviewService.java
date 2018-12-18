package com.acsk.shop.service;

import com.acsk.shop.model.user.Rating;
import com.acsk.shop.model.user.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviwByUserId(Long id);
    List<Review> getReviewByShopId(Long id);
    List<Review> getReviewByShopIdAndUserId(Long shopId, Long userId);
    Review addReview(Review review);
}

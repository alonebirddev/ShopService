package com.acsk.shop.repository;

import com.acsk.shop.model.user.Rating;
import com.acsk.shop.model.user.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByUserId(Long id);
    List<Review> findByShopId(Long id);
    List<Review> findByShopIdAndUserId(Long shopId, Long userId);
}

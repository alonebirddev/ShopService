package com.acsk.shop.service;

import com.acsk.shop.repository.UserRepository;
import com.acsk.shop.dto.UserProfile;
import com.acsk.shop.model.user.BmbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RatingService ratingService;

    @Autowired
    ReviewService reviewService;

    @Override
    public BmbUser getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public BmbUser addUser(BmbUser bmbUser) {
        return userRepository.save(bmbUser);
    }

    @Override
    public UserProfile getUserProfile(Long userId) {
        UserProfile userProfile = new UserProfile();
        userProfile.setBmbUser(userRepository.findOne(userId));
        userProfile.setReviewList(reviewService.getReviwByUserId(userId));
        userProfile.setRatingList(ratingService.getRatingByUserId(userId));
        return userProfile;
    }
}

package com.acsk.shop.repository;

import com.acsk.shop.model.user.BmbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BmbUser, Long> {
}

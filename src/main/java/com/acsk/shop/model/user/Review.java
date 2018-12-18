package com.acsk.shop.model.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "jpa_review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bmb_review_id")
    Long id;
    Long userId;
    Long shopId;
    String reviewContent;
    int usefulCount;
    int notUsefulCount;
    int spamCount;
}

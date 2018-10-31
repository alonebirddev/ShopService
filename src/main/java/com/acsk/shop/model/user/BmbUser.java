package com.acsk.shop.model.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "jpa_bmb_user")
public class BmbUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bmb_user_id")
    Long id;
    String firstName;
    String lastName;
    String userName;
    String email;
    long phone;
    String city;
}

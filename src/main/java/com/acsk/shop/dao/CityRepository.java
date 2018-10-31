package com.acsk.shop.dao;

import com.acsk.shop.model.configuration.City;
import com.acsk.shop.model.configuration.StockServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
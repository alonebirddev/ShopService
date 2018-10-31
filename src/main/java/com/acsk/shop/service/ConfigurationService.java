package com.acsk.shop.service;

import com.acsk.shop.model.configuration.City;
import com.acsk.shop.model.configuration.StockServices;

import java.util.List;

public interface ConfigurationService {
    List<StockServices> getAllStockServices();
    List<City> getAllCities();
    StockServices addStockService(StockServices stockServices);
    City addNewCity(City city);
    City getCity(Long id);
    StockServices getStockServices(Long id);
}

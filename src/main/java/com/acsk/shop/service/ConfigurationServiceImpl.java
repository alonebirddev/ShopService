package com.acsk.shop.service;

import com.acsk.shop.dao.CityRepository;
import com.acsk.shop.dao.ServiceRepository;
import com.acsk.shop.model.configuration.City;
import com.acsk.shop.model.configuration.StockServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<StockServices> getAllStockServices() {
        return serviceRepository.findAll();
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public StockServices addStockService(StockServices stockServices) {
        return serviceRepository.save(stockServices);
    }

    @Override
    public City addNewCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City getCity(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public StockServices getStockServices(Long id) {
        return serviceRepository.findOne(id);
    }
}

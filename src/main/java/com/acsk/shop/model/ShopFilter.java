package com.acsk.shop.model;

import java.util.List;

public class ShopFilter {
    List<String> shopCity;
    List<String> shopArea;
    List<Long> shopServices;

    public List<String> getShopCity() {
        return shopCity;
    }

    public void setShopCity(List<String> shopCity) {
        this.shopCity = shopCity;
    }

    public List<String> getShopArea() {
        return shopArea;
    }

    public void setShopArea(List<String> shopArea) {
        this.shopArea = shopArea;
    }

    public List<Long> getShopServices() {
        return shopServices;
    }

    public void setShopServices(List<Long> shopServices) {
        this.shopServices = shopServices;
    }
}

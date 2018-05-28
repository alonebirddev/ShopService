package com.acsk.shop.service;

import java.util.List;

import com.acsk.shop.model.Shop;
import com.acsk.shop.model.ShopFilter;
import com.acsk.shop.util.ShopException;

import javax.net.ssl.SNIHostName;

public interface ShopService {
	public List<Shop> getAllShops() throws ShopException;
	public Shop getShop(long id) throws ShopException;
	public boolean addShop(Shop shop) throws ShopException;
	public List<Shop> getShopByFilter(ShopFilter shopFilter) throws ShopException;
}

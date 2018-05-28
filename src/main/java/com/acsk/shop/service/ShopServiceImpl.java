package com.acsk.shop.service;

import java.util.List;

import com.acsk.shop.model.ShopFilter;
import com.acsk.shop.util.ShopException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsk.shop.dao.ShopDao;
import com.acsk.shop.model.Shop;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopDao shopDao; 
	
	public List<Shop> getAllShops() {
		return shopDao.getAllShops();
	}
	public Shop getShop(long id) {
		return shopDao.getShop(id);
	}
	public boolean addShop(Shop shop) {
		shopDao.addShop(shop);
		return true;
	}

	@Override
	public List<Shop> getShopByFilter(ShopFilter shopFilter) throws ShopException {
		return shopDao.getShopByFilter(shopFilter);
	}

}

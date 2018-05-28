package com.acsk.shop.controller;

import java.util.List;

import com.acsk.shop.util.ShopException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.acsk.shop.model.Shop;
import com.acsk.shop.service.ShopService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
//@RequestMapping("/shop")
@Api(value="Shops", description="Operations pertaining to shop data from shop table.")
public class ShopController {

	/*@Autowired
	public ShopService shopService;
	
	@ApiOperation(value = "View a list of available shops", response = Shop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping("/shop")
	public ResponseEntity<List<Shop>> getAllShops()throws ShopException {
		List<Shop> list = shopService.getAllShops();
		return new ResponseEntity<List<Shop>>(list, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "get single shop", response = Shop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping("/shop/{id}")
	public ResponseEntity<Shop> getArticleById(@PathVariable("id") Integer id) {
		Shop shop = shopService.getShop(id);
		return new ResponseEntity<Shop>(shop, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "add new shop", response = Shop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@PostMapping("shop")
	public ResponseEntity<Void> addArticle(@RequestBody Shop shop, UriComponentsBuilder builder) {
		boolean flag = shopService.addShop(shop);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/shop/{id}").buildAndExpand(shop.getShop_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}*/
}

package com.acsk.shop.controller;

import com.acsk.shop.model.RestResponse;
import com.acsk.shop.model.Shop;
import com.acsk.shop.model.ShopFilter;
import com.acsk.shop.service.ShopService;
import com.acsk.shop.util.ShopException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
//@RequestMapping("/bmb")
@Api(value="Shops", description="Operations pertaining to shop data from shop table.")
public class ShopsController {
    private static final Logger LOGGER = LogManager.getLogger(ShopController.class);

    @Autowired
    private ShopService shopService;

    @ApiOperation(value = "View a list of available shops", response = Shop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ResponseEntity<List<Shop>> getAllShop() {
        LOGGER.traceEntry();
        HttpStatus status = HttpStatus.OK;
        try {
            List<Shop> shops = shopService.getAllShops();
            return LOGGER.traceExit(new ResponseEntity<>(shops, status));
        } catch (ShopException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (IllegalArgumentException e) {
            status = HttpStatus.BAD_REQUEST;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (Exception exception) {
            LOGGER.error("Exception while retriving shops ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to retive shops - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }

    @ApiOperation(value = "get shop by id", response = Shop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/shop/{id}", method = RequestMethod.GET)
    public ResponseEntity<Shop> getShop(@PathVariable("id") long id) {
        LOGGER.traceEntry();
        HttpStatus status = HttpStatus.OK;
        try {
            Shop shop = shopService.getShop(id);
            return LOGGER.traceExit(new ResponseEntity<>(shop, status));
        } catch (ShopException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (IllegalArgumentException e) {
            status = HttpStatus.BAD_REQUEST;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (Exception exception) {
            LOGGER.error("Exception while retriving shops ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to retive shops - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }

    @ApiOperation(value = "insert new shop", response = Shop.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/shop", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveShop(@RequestBody Shop shop) throws ShopException {
        LOGGER.traceEntry();
        HttpStatus status = HttpStatus.OK;
        try {
            boolean flag = shopService.addShop(shop);
            return LOGGER.traceExit(new ResponseEntity<>(flag, status));
        } catch (ShopException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (IllegalArgumentException e) {
            status = HttpStatus.BAD_REQUEST;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (Exception exception) {
            LOGGER.error("Exception provisioning the product ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to provision the account - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }

    @ApiOperation(value = "filter shops by services and area", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/shop/filter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Shop>> shopFilter(@RequestBody ShopFilter shopFilter) throws ShopException {
        LOGGER.traceEntry();
        HttpStatus status = HttpStatus.OK;
        try {
            return LOGGER.traceExit(new ResponseEntity<>(shopService.getShopByFilter(shopFilter), status));
        } catch (ShopException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (IllegalArgumentException e) {
            status = HttpStatus.BAD_REQUEST;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (Exception exception) {
            LOGGER.error("Exception provisioning the product ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to provision the account - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }
}

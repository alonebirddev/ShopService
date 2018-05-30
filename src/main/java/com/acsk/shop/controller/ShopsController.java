package com.acsk.shop.controller;

import com.acsk.shop.model.RestResponse;
import com.acsk.shop.model.Services;
import com.acsk.shop.model.Shop;
import com.acsk.shop.model.ShopFilter;
import com.acsk.shop.service.ShopService;
import com.acsk.shop.util.ShopException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Response;
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
    private static final Logger LOGGER = LogManager.getLogger(ShopsController.class);

    @Autowired
    private ShopService shopService;

    @ApiOperation(value = "View a list of available shops", notes = "Retrieve all shops", tags = {
            ("Shop") })
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
            LOGGER.error("Exception while retrieving shops ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to retrieve shops - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }

    @ApiOperation(value = "Get shop by id", notes = "Retrieve shop details by Shop Id.", tags = {
            ("Shop") })
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
            LOGGER.error("Exception while retrieving shop details ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to retrieve shop - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }

    @ApiOperation(value = "Insert new shop", notes = "Add new shop details to system", tags = {
            ("Shop") })
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
            LOGGER.error("Exception while adding new Shop details ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to add new Shop details - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }

    @ApiOperation(value = "Filter shops by services and area", notes = "Retrieve shops based on services are area", tags = {
            ("Shop") })
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
            LOGGER.error("Exception while retrieving shops ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to retrieve shops - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }

    @ApiOperation(value = "Get shops by city using ZIP code", notes = "Retrieve shops by zip code i.e. city", tags = {
            ("Shop") })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/shop/city/{zip}", method = RequestMethod.GET)
    public ResponseEntity<List<Shop>> getShopsByCity(@PathVariable("zip") String zip) {
        LOGGER.traceEntry();
        HttpStatus status = HttpStatus.OK;
        try {
            List<Shop> shops = shopService.getShopByCity(zip);
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
            LOGGER.error("Exception while retrieving shops ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to retrieve shops - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }

    @ApiOperation(value = "Get services for Shop", notes = "Retrieve shops services using shop id", tags = {
            ("Services")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/services/shop/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Services>> getShopsServiceByShopId(@PathVariable("id") long id) {
        LOGGER.traceEntry();
        HttpStatus status = HttpStatus.OK;
        try {
            List<Services> services = shopService.getShopsServiceByShopId(id);
            return LOGGER.traceExit(new ResponseEntity<>(services, status));
        } catch (ShopException e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (IllegalArgumentException e) {
            status = HttpStatus.BAD_REQUEST;
            LOGGER.error("Error", e);
            return RestResponse.createErrorResponse(status, e.getMessage());
        } catch (Exception exception) {
            LOGGER.error("Exception while retrieving services ", exception);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            return RestResponse.createErrorResponse(status,
                    "Unable to retrieve services - with error: " + exception.getMessage());
        } finally {
            LOGGER.traceExit(status);
        }
    }
}

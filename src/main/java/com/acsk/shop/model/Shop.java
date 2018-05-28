package com.acsk.shop.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.acsk.shop.util.Epayment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "bmb_shop")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    @ApiModelProperty(notes = "The database generated recipe ID")
    long shopId;
    String shopName;
    String shopAddress;
    String shopArea;
    String shopCity;
    String shopDescription;
    String shopLandMark;
    String shopType;
    String shopZip;

    @Column(name = "aggregateRating", columnDefinition = "Decimal(10,2) default '1.0'")
    private double aggregateRating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geo_id")
    private GeoLocation geoLocation;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "bmb_shop_opening_hours_xref",
            joinColumns = @JoinColumn(name = "shop_id"),
            inverseJoinColumns = @JoinColumn(name = "openhrs_id")
    )
    private Set<OpeningHours> openingHours = new HashSet<OpeningHours>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "bmb_shop_services_xref",
            joinColumns = {@JoinColumn(name = "shop_id")},
            inverseJoinColumns = {@JoinColumn(name = "service_id")})
    //@JsonManagedReference
    private Set<Services> services = new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopArea() {
        return shopArea;
    }

    public void setShopArea(String shopArea) {
        this.shopArea = shopArea;
    }

    public String getShopCity() {
        return shopCity;
    }

    public void setShopCity(String shopCity) {
        this.shopCity = shopCity;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getShopLandMark() {
        return shopLandMark;
    }

    public void setShopLandMark(String shopLandMark) {
        this.shopLandMark = shopLandMark;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getShopZip() {
        return shopZip;
    }

    public void setShopZip(String shopZip) {
        this.shopZip = shopZip;
    }

    public double getAggregateRating() {
        return aggregateRating;
    }

    public void setAggregateRating(double aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Set<OpeningHours> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Set<OpeningHours> openingHours) {
        this.openingHours = openingHours;
    }

    public Set<Services> getServices() {
        return services;
    }

    public void setServices(Set<Services> services) {
        this.services = services;
    }

    //@ElementCollection
    //@CollectionTable(name="bmb_shop_services")
    //List<Services> services;
	
	/*//private List<Map<String, String>> openingHours;
	
	@ElementCollection
    @MapKeyColumn(name="day")
    @Column(name="hrs")
    @CollectionTable(name="Shop_OpeningHours", joinColumns=@JoinColumn(name="shop_id"))
    Map<String, String> openingHours = new HashMap<String, String>(); // maps from attribute name to value
*/

    //@Enumerated(EnumType.STRING)
    //private Epayment epayments;
    //private List<Double> priceRange;

	
/*	public List<Map<String, String>> getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(List<Map<String, String>> openingHours) {
		this.openingHours = openingHours;
	}
	public List<Double> getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(List<Double> priceRange) {
		this.priceRange = priceRange;
	}*/

}

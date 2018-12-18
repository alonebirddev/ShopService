package com.acsk.shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jpa_services")
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="service_id")
	private Long id;
	private double price;
	private String name;
	private String description;
	private Long serviceCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shop_id")
	@JsonIgnore
	private Shop shop;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Long getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(Long serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}

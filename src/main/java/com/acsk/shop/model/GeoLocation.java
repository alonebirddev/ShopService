package com.acsk.shop.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "bmb_geo_location")
public class GeoLocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String lng;
	private String lat;

    @OneToOne(mappedBy = "geoLocation")
	Shop shop;

	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}

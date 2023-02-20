package com.okta.poc.dto;

public class GeographicalContextDTO {

	private String city;
	private String state;
	private String country;
	private String postalCode;

	private GeoLocationDTO geolocation;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public GeoLocationDTO getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(GeoLocationDTO geolocation) {
		this.geolocation = geolocation;
	}

}

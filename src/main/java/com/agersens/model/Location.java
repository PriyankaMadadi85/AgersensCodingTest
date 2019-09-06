package com.agersens.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Location {
	@NotNull
	@Pattern(regexp = "/^[+-]?(([1-8]?[0-9])(\\.[0-9]{1,6})?|90(\\.0{1,6})?)$/")
	private double lat;
	
	@NotNull
	@Pattern(regexp = "/^[+-]?((([1-9]?[0-9]|1[0-7][0-9])(\\.[0-9]{1,6})?)|180(\\.0{1,6})?)$/")
	private double lng;
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
	
}

package com.agersens.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class AnimalData {
	@NotNull
	private String name;
	@NotNull
	@Max(1000)
	private Integer months;
	@NotNull
	private Location location;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	 
	
}

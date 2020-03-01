package com.rkb.models;

public class LocationStat {
	
	private String country;
	private String state;
	private String lat;
	private String lng;
	private String cases;
	public LocationStat() {
		super();
	}
	public LocationStat(String country, String state, String lat, String lng, String cases) {
		super();
		this.country = country;
		this.state = state;
		this.lat = lat;
		this.lng = lng;
		this.cases = cases;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getCases() {
		return cases;
	}
	public void setCases(String cases) {
		this.cases = cases;
	}
	@Override
	public String toString() {
		return "LocationStat [country=" + country + ", state=" + state + ", lat=" + lat + ", lng=" + lng + ", cases="
				+ cases + "]";
	}
	
	
}

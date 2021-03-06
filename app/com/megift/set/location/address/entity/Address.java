package com.megift.set.location.address.entity;

import com.megift.resources.base.Entity;
import com.megift.set.location.city.entity.City;
import com.megift.set.location.geolocation.entity.Geolocation;

/**
 * @class : Address.java<br/>
 * @company : Megift S.A<br/>
 * @user : YQ<br/>
 * @date : Feb 23, 2015<br/>
 * @update date : Feb 23, 2015<br/>
 * @update by : Feb 23, 2015<br/>
 * @version : 0.1 <br/>
 * @author Yonatan Alexis Quintero Rodriguez
 * 
 */
public class Address extends Entity {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private String address;
	private City city;
	private Geolocation geolocation;

	/**
	 * @param id
	 */
	public Address(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public Address(City city) {
		super(0);
		this.city = city;
	}

	public Address(Geolocation geolocation) {
		super(0);
		this.geolocation = geolocation;
	}

	/**
	 * @param address
	 */
	public Address(String address) {
		super(0);
		this.address = address;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.megift.resources.base.Entity#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Geolocation getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(Geolocation geolocation) {
		this.geolocation = geolocation;
	}

}

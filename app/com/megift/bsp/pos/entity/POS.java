package com.megift.bsp.pos.entity;

import java.util.List;

import com.megift.bsp.gift.entity.Gift;
import com.megift.bsp.partner.entity.Partner;
import com.megift.resources.base.Entity;
import com.megift.set.location.entity.Location;

/**
 * @class : POS.java<br/>
 * @company : Megift S.A<br/>
 * @user : YQ<br/>
 * @date : Feb 26, 2015<br/>
 * @update date : Feb 26, 2015<br/>
 * @update by : Feb 26, 2015<br/>
 * @version : 0.1 <br/>
 * @author Yonatan Alexis Quintero Rodriguez
 * 
 */
public class POS extends Entity {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private String name;
	private Partner contact;
	private Location location;
	private List<Gift> giftList;

	/**
	 * @param id
	 */
	public POS(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.megift.resources.base.Entity#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Partner getContact() {
		return contact;
	}

	public void setContact(Partner contact) {
		this.contact = contact;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the giftList
	 */
	public List<Gift> getGiftList() {
		return giftList;
	}

	/**
	 * @param giftList
	 *            the giftList to set
	 */
	public void setGiftList(List<Gift> giftList) {
		this.giftList = giftList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
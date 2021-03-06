package com.megift.bsp.term_and_condition;

import com.megift.resources.base.Entity;

/**
 * @class : TermAndCondition.java<br/>
 * @company : Megift S.A<br/>
 * @user : YQ<br/>
 * @date : Feb 26, 2015<br/>
 * @update date : Feb 26, 2015<br/>
 * @update by : Feb 26, 2015<br/>
 * @version : 0.1 <br/>
 * @author Yonatan Alexis Quintero Rodriguez
 *
 */
public class TermAndCondition extends Entity {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;

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

	/**
	 * @param id
	 */
	public TermAndCondition(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param int1
	 * @param string
	 */
	public TermAndCondition(int id, String description) {
		super(id);
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.megift.resources.base.Entity#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if (description == null)
			return true;
		else if (description.isEmpty())
			return true;
		else if (description.length() <= 0)
			return true;
		else if (description.equals(""))
			return true;
		else
			return false;

	}
}

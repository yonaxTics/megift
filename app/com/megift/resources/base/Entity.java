package com.megift.resources.base;

import static com.megift.resources.utils.Constants.DATE_TIME_FORMATTER;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Entity implements Serializable, Cloneable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected LocalDateTime created;

	public Entity(int id) {
		this.id = id;
	}

	public String getFormatCreated() {
		String formateDate = null;
		if (created != null)
			formateDate = created.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER));
		return formateDate;
	}

	public abstract boolean isEmpty();

	public boolean exists() {
		return this.id > 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

}

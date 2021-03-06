package com.megift.bsp.gift.entity;

import static com.megift.resources.utils.Constants.DATE_FORMATTER;
import static com.megift.resources.utils.Utils.getElapsaTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.megift.bsp.action.entity.Action;
import com.megift.bsp.pos.entity.POS;
import com.megift.bsp.relationgiftpos.entity.RelationGiftPOS;
import com.megift.bsp.term_and_condition.TermAndCondition;
import com.megift.resources.base.Entity;
import com.megift.resources.utils.Utils;
import com.megift.set.master.entity.MasterValue;
import com.megift.set.picture.entity.Picture;

/**
 * @class : Gift.java<br/>
 * @company : Megift S.A<br/>
 * @user : YQ<br/>
 * @date : Feb 26, 2015<br/>
 * @update date : Feb 26, 2015<br/>
 * @update by : Feb 26, 2015<br/>
 * @version : 0.1 <br/>
 * @author Yonatan Alexis Quintero Rodriguez
 * 
 */
public class Gift extends Entity {

	public static final int OTHER_TYPE = 24;
	public static final int INACTIVE = 28;
	public static final int RESULTS_BY_GIFTS = 0;
	public static final int RESULTS_BY_ACTIONS = 1;
	public static final int RESULTS_BY_POS = 2;
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private Action action;
	private MasterValue type;
	private String otherType;
	private MasterValue status;
	private double price;
	private LocalDateTime startDate;
	private LocalDateTime expirationDate;
	private String name;
	private String description;
	private List<Picture> pictures;
	private Picture mainPicture;
	// TODO: se reemplazon por un String
	private List<TermAndCondition> termsAndConditions;
	private List<POS> posList;
	private POS pos;
	private List<RelationGiftPOS> giftPOSList;
	private String termsConditions;
	private int position;

	/**
	 * @param id
	 */
	public Gift(int id) {
		super(id);
	}

	// TODO:Quitar
	public String getExpirationTime() {
		if (startDate != null && expirationDate != null) {
			String hours = String.valueOf(ChronoUnit.HOURS.between(startDate, expirationDate));
			return hours.concat(":00:00");
		} else {
			return "";
		}
		// return getElapsaTime(startDate,new
		// Date(expirationDate.toLocalDate().getM));
	}

	public String getElapseTimeDays() {
		String elapseTime = "0 Horas";
		if (expirationDate != null) {
			Long h = ChronoUnit.HOURS.between(LocalDateTime.now(), expirationDate);
			if (h > 24) {
				Long d = ChronoUnit.DAYS.between(LocalDateTime.now(), expirationDate);
				elapseTime = String.valueOf(d.intValue()).concat(" Dias");
			} else if (h < 1) {
				Long m = ChronoUnit.MINUTES.between(LocalDateTime.now(), expirationDate);
				elapseTime = String.valueOf(m.intValue()).concat(" Minutos");
			} else {
				elapseTime = String.valueOf(h.intValue()).concat(" Horas");
			}
		}
		return elapseTime;
	}

	public String getElapseTime() {
		if (expirationDate != null) {
			return getElapsaTime(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("America/Bogota")), expirationDate);
		} else {
			return "";
		}

	}

	public String getFormatStartDate() {
		if (startDate != null) {
			return startDate.format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
		} else {
			return "";
		}
	}

	public String getFormatExpirtationtDate() {
		if (expirationDate != null) {
			return expirationDate.format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
		} else {
			return "";
		}
	}

	@Override
	public boolean isEmpty() {
		return name == null;
	}

	public boolean equals(Gift gift) {
		return id == gift.getId();
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public MasterValue getType() {
		return type;
	}

	public void setType(MasterValue type) {
		this.type = type;
	}

	public String getOtherType() {
		return otherType;
	}

	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
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

	/**
	 * @return the pictures
	 */
	public List<Picture> getPictures() {
		return pictures;
	}

	/**
	 * @param pictures
	 *            the pictures to set
	 */
	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	/**
	 * @return the termsAndConditions
	 */
	public List<TermAndCondition> getTermsAndConditions() {
		return termsAndConditions;
	}

	/**
	 * @param termsAndConditions
	 *            the termsAndConditions to set
	 */
	public void setTermsAndConditions(List<TermAndCondition> termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	/**
	 * @return
	 */
	public boolean isOtherType() {
		if (type != null) {
			return type.getId() == OTHER_TYPE;
		}
		return false;
	}

	public MasterValue getStatus() {
		if (expirationDate != null) {
			if (ChronoUnit.MINUTES.between(LocalDateTime.now(), expirationDate) <= 0) {
				if (status != null) {
					status.setId(INACTIVE);
				}
			}
		}
		return status;
	}

	public void setStatus(MasterValue status) {
		this.status = status;
	}

	public List<RelationGiftPOS> getGiftPOSList() {
		return giftPOSList;
	}

	public void setGiftPOSList(List<RelationGiftPOS> giftPOSList) {
		this.giftPOSList = giftPOSList;
	}

	/**
	 * @return the posList
	 */
	public List<POS> getPosList() {
		return posList;
	}

	/**
	 * @param posList
	 *            the posList to set
	 */
	public void setPosList(List<POS> posList) {
		this.posList = posList;
	}

	public POS getPos() {
		return pos;
	}

	public void setPos(POS pos) {
		this.pos = pos;
	}

	/**
	 * @return the termsConditions
	 */
	public String getTermsConditions() {
		return termsConditions;
	}

	/**
	 * @param termsConditions
	 *            the termsConditions to set
	 */
	public void setTermsConditions(String termsConditions) {
		this.termsConditions = termsConditions;
	}

	public String getPriceFormatted() {
		return Utils.priceWithoutDecimal(price, "$");
	}

	/**
	 * @return the mainPicture
	 */
	public Picture getMainPicture() {
		return mainPicture;
	}

	/**
	 * @param mainPicture
	 *            the mainPicture to set
	 */
	public void setMainPicture(Picture mainPicture) {
		this.mainPicture = mainPicture;
	}

	public boolean hasMainPicture() {
		return mainPicture != null;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}

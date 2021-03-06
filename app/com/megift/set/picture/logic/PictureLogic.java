package com.megift.set.picture.logic;

import java.util.List;

import com.megift.bsp.action.entity.Action;
import com.megift.bsp.business.dao.BusinessDao;
import com.megift.bsp.business.entity.Business;
import com.megift.bsp.gift.entity.Gift;
import com.megift.bsp.partner.dao.PartnerDao;
import com.megift.bsp.partner.entity.Partner;
import com.megift.set.picture.dao.PictureDao;
import com.megift.set.picture.entity.Picture;

/**
 * company : Megift S.A<br/>
 * user : YQ<br/>
 * date : Feb 19, 2015<br/>
 * update date : Feb 19, 2015<br/>
 * update by : Yonatan Alexis Quintero Rodriguez<br/>
 * 
 * @version : 0.1 <br/>
 * @author Yonatan Alexis Quintero Rodriguez
 * 
 */
public class PictureLogic {
	/**
	 * @param picture
	 * @return
	 */
	public static boolean savePicturePartner(Partner partner) {
		boolean result = false;
		if (partner.getPicture().exists()) {
			result = PictureDao.update(partner.getPicture());
		} else if (partner.exists()) {
			result = PictureDao.create(partner.getPicture());
			if (partner.getPicture().exists()) {
				result = PartnerDao.updatePicture(partner);
			}
		}
		return result;
	}

	/**
	 * @param gift
	 * @return
	 */
	public static boolean savePictureCollection(Gift gift) {
		boolean result = false;
		Picture picture = gift.getPictures().get(0);
		if (picture.exists()) {
			result = PictureDao.update(picture);
		} else if (gift.exists()) {
			result = PictureDao.create(picture);
			if (picture.exists()) {
				result = PictureDao.createPictureCollection(gift);
			}
		}
		return result;
	}

	/**
	 * @param gift
	 * @return
	 */
	public static boolean savePictureCollection(Action action) {
		boolean result = false;
		Picture picture = action.getPictures().get(0);
		if (picture.exists()) {
			result = PictureDao.update(picture);
		} else if (action.exists()) {
			result = PictureDao.create(picture);
			if (picture.exists()) {
				result = PictureDao.createPictureCollection(action);
			}
		}
		return result;
	}

	/**
	 * @return
	 */
	public static boolean loadPicturesByGift(Gift gift) {
		boolean result = false;
		if (gift.exists()) {
			result = PictureDao.loadPicturesByGift(gift);
		}
		return result;
	}

	/**
	 * @return
	 */
	public static boolean loadPicturesByAction(Action action) {
		boolean result = false;
		if (action.exists()) {
			result = PictureDao.loadPicturesByAction(action);
		}
		return result;
	}

	/**
	 * @param gifList
	 * @return
	 */
	public static boolean loadPicturesByGiftList(List<Gift> giftList) {
		boolean result = false;
		if (giftList != null && !giftList.isEmpty()) {
			for (Gift gift : giftList) {
				result = PictureDao.loadPicturesByGift(gift);
			}
		}
		return result;
	}

	/**
	 * @param giftList
	 * @return
	 */
	/*
	 * public static boolean loadMainPicturesByGiftList(List<Gift> giftList) {
	 * boolean result = false; if (giftList != null && !giftList.isEmpty()) {
	 * result = PictureDao.loadMainPicturesByGiftList(giftList); } return
	 * result; }
	 */

	public static boolean loadMainPictureByGiftList(List<Gift> giftList) {
		boolean result = false;
		if (giftList != null && !giftList.isEmpty()) {
			result = PictureDao.loadMainPictureByGiftList(giftList);
		}
		return result;
	}

	public static boolean loadMainPictureByActionList(List<Action> actionList) {
		boolean result = false;
		if (actionList != null && !actionList.isEmpty()) {
			result = PictureDao.loadMainPictureByActionList(actionList);
		}
		return result;
	}

	public static boolean loadActionMainPictureByGiftList(List<Gift> giftList) {
		boolean result = false;
		if (giftList != null && !giftList.isEmpty()) {
			result = PictureDao.loadActionMainPictureByGiftList(giftList);
		}
		return result;
	}

	/**
	 * @param business
	 * @return
	 */
	public static boolean savePictureBusiness(Business business) {
		boolean result = false;
		if (business.getPicture().exists()) {
			result = PictureDao.update(business.getPicture());
		} else if (business.exists()) {
			result = PictureDao.create(business.getPicture());
			if (business.getPicture().exists()) {
				result = BusinessDao.updatePicture(business);
			}
		}
		return result;
	}
}

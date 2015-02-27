package com.megift.bsp.business.entity;

import java.util.List;

import com.megift.bsp.partner.entity.Partner;
import com.megift.bsp.pos.entity.POS;
import com.megift.resources.base.Entity;
import com.megift.set.location.entity.Location;
import com.megift.set.master.entity.MasterValue;

/** 
 * @class        : Business.java<br/>
 * @company      : Megift S.A<br/>
 * @user         : YQ<br/> 
 * @date         : Feb 26, 2015<br/> 
 * @update date  : Feb 26, 2015<br/> 
 * @update by    : Feb 26, 2015<br/> 
 * @version      : 0.1 <br/>
 * @author Yonatan Alexis Quintero Rodriguez
 *
 */
public class Business extends Entity {


    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Partner legalRepresentative;
    private Partner contact;
    private Location location;
    private MasterValue type;
    private String otherType;
    private String NIT;
    private String tradeName;
    private String legalName;
    private List<POS> posList;

    /**
     * @param id
     */
    public Business(int id) {
        super(id);
        // TODO Auto-generated constructor stub
    }
    /* (non-Javadoc)
     * @see com.megift.resources.base.Entity#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    public Partner getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(Partner legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
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

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String nIT) {
        NIT = nIT;
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
    /**
     * @return the tradeName
     */
    public String getTradeName() {
        return tradeName;
    }
    /**
     * @param tradeName the tradeName to set
     */
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }
    /**
     * @return the legalName
     */
    public String getLegalName() {
        return legalName;
    }
    /**
     * @param legalName the legalName to set
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

}
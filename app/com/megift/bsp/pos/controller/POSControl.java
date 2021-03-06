/**
 * 
 */
package com.megift.bsp.pos.controller;

import static com.megift.resources.utils.Constants.SESSION_BUSINESS_ID;
import static com.megift.resources.utils.Constants.SESSION_LOGIN_ID;
import static com.megift.resources.utils.Constants.SUCCESS_RESPONSE;

import java.util.Map;

import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.megift.bsp.business.entity.Business;
import com.megift.bsp.gift.entity.Gift;
import com.megift.bsp.partner.entity.Partner;
import com.megift.bsp.partner.logic.PartnerLogic;
import com.megift.bsp.pos.entity.POS;
import com.megift.bsp.pos.logic.POSLogic;
import com.megift.set.location.address.entity.Address;
import com.megift.set.location.address.logic.AddressLogic;
import com.megift.set.location.entity.Location;
import com.megift.set.location.geolocation.entity.Geolocation;
import com.megift.set.location.geolocation.logic.GeolocationLogic;
import com.megift.set.location.logic.LocationLogic;
import com.megift.set.location.phone.entity.Phone;
import com.megift.set.location.phone.logic.PhoneLogic;

/**
 * company : Megift S.A<br/>
 * user : YQ<br/>
 * created : Mar 2, 2015<br/>
 * update date : Mar 2, 2015<br/>
 * update by : Yonatan Alexis Quintero Rodriguez<br/>
 * 
 * @version : 0.1 <br/>
 * @author Yonatan Alexis Quintero Rodriguez
 * 
 */
public class POSControl extends Controller {

	public static Result POSList() {
		if (session(SESSION_LOGIN_ID) == null) {
			return redirect("/login");
		}
		return ok(views.html.bsp.POS.POSList.render());
	}

	public static Result POS() {
		if (session(SESSION_LOGIN_ID) == null) {
			return redirect("/login");
		}
		return ok(views.html.bsp.POS.POS.render());

	}

	public static Result savePOS() {
		try {
			if (session(SESSION_LOGIN_ID) == null) {
				return redirect("/login");
			}
			String result = "No se ha podido completar la solicitud";
			final Map<String, String[]> data = request().body().asFormUrlEncoded();

			if (data != null && session(SESSION_BUSINESS_ID) != null) {
				Geolocation geolocation = new Geolocation(Integer.parseInt(data.get("id-geolocation-pos")[0]));
				geolocation.setLongitude(Double.parseDouble(data.get("longitude-address-pos")[0]));
				geolocation.setLatitude(Double.parseDouble(data.get("latitude-address-pos")[0]));
				if (GeolocationLogic.save(geolocation)) {
					Address address = new Address(Integer.parseInt(data.get("id-address-pos")[0]));
					address.setAddress(data.get("address-pos")[0]);
					address.setGeolocation(geolocation);
					if (AddressLogic.save(address)) {
						Phone phone = new Phone(Integer.parseInt(data.get("id-phone-pos")[0]));
						phone.setNumber(data.get("phone-pos")[0]);
						phone.setExtension(data.get("extension-phone-pos")[0]);
						phone.setMobile(data.get("mobile-phone-pos")[0]);
						if (PhoneLogic.save(phone)) {
							Location location = new Location(Integer.parseInt(data.get("id-location-pos")[0]));
							location.setAddress(address);
							location.setPhone(phone);
							if (LocationLogic.save(location)) {
								Partner contact = new Partner(Integer.parseInt(data.get("id-contact")[0]));
								contact.setName(data.get("name-contact")[0]);
								if (PartnerLogic.save(contact)) {
									POS pos = new POS(Integer.parseInt(data.get("id-POS")[0]));
									pos.setName(data.get("name-POS")[0]);
									pos.setEmail(data.get("email-POS")[0]);
									pos.setWebSite(data.get("web-site-pos")[0]);
									pos.setBussinesId(Integer.parseInt(session(SESSION_BUSINESS_ID)));
									pos.setContact(contact);
									pos.setLocation(location);
									if (POSLogic.save(pos)) {
										result = Json.toJson(pos).toString();
									} else {
										result = "error guardando el Punto de venta!";
									}
								} else {
									result = "Error guardando el contacto";
								}
							} else {
								result = "Error guardando la localización";
							}
						} else {
							result = "Error guardando los teléfonos";
						}
					} else {
						result = "Error guardando la dirección";
					}
				} else {
					result = "Error guardando la geolocalización";
				}
			}
			return ok(result);
		} catch (Exception e) {
			Logger.error("Ha ocurrido un error intentando guardar el punto de venta \n" + e.getMessage(), e);
			return badRequest("Ha ocurrido un error intentando guardar el punto de venta ( " + e.getMessage() + " )");
		}
	}

	public static Result loadPOSByBusiness() {
		try {
			if (session(SESSION_LOGIN_ID) == null) {
				return redirect("/login");
			}
			Business business = new Business(Integer.parseInt(session(SESSION_BUSINESS_ID)));
			if (POSLogic.loadPOSByBusiness(business)) {
				return ok(Json.toJson(business.getPosList()));
			}
			return ok("No hay puntos de venta para mostrar");
		} catch (Exception e) {
			Logger.error("Ha ocurrido un error intentando cargar los puntos de venta \n" + e.getMessage(), e);
			return badRequest("Ha ocurrido un error cargar los puntos de venta ( " + e.getMessage() + " )");
		}
	}

	public static Result loadPOS(int id) {
		try {
			if (session(SESSION_LOGIN_ID) == null) {
				return redirect("/login");
			}
			return ok(Json.toJson(POSLogic.load(new POS(id))));
		} catch (Exception e) {
			Logger.error("Ha ocurrido un error intentando cargar el punto de venta \n" + e.getMessage(), e);
			return badRequest("Ha ocurrido un error intentando cargar el punto de venta ( " + e.getMessage() + " )");
		}
	}

	/*
	 * Todos los puntos de venta que tiene como este regalo y ademas trae
	 * tambien los que no tiene el regalo para que se puedan seleccioanr desde
	 * el cliente
	 */
	public static Result loadPOSByGift(int id) {
		try {
			if (session(SESSION_LOGIN_ID) == null) {
				return redirect("/login");
			}
			Business business = new Business(Integer.parseInt(session(SESSION_BUSINESS_ID)));
			Gift gift = new Gift(id);
			if (POSLogic.loadPOSByGift(business, gift)) {
				return ok(Json.toJson(business.getPosList()));
			}
			return ok("No hay puntos de venta para mostrar");
		} catch (Exception e) {
			Logger.error("Ha ocurrido un error intentando cargar los puntos de venta \n" + e.getMessage(), e);
			return badRequest("Ha ocurrido un error intentando cargar los puntos de venta ( " + e.getMessage() + " )");
		}
	}

	/*
	 * Asociar este regalo a este punto de venta
	 */
	public static Result associateGifToPOS(int idPos, int idGift) {
		try {
			if (session(SESSION_LOGIN_ID) == null) {
				return redirect("/login");
			}
			String result = "No se ha podido completar la solicitud";
			POS pos = new POS(idPos);
			pos.setGift(new Gift(idGift));
			if (POSLogic.associateGiftToPOS(pos)) {
				result = SUCCESS_RESPONSE;
			} else {
				result = "Error intentando asociar el regalo al punto de venta";
			}
			return ok(result);
		} catch (Exception e) {
			Logger.error("Ha ocurrido un error intentando asociar este regalo \n" + e.getMessage(), e);
			return badRequest("Ha ocurrido un error intentando asociar este regalo ( " + e.getMessage() + " )");
		}
	}

	/*
	 * Eliminar este regalo de este punto de venta
	 */
	public static Result removeGiftOfPOS(int idPos, int idGift) {
		try {
			if (session(SESSION_LOGIN_ID) == null) {
				return redirect("/login");
			}
			String result = "No se ha podido completar la solicitud";
			POS pos = new POS(idPos);
			pos.setGift(new Gift(idGift));
			if (POSLogic.removeGiftToPOS(pos)) {
				result = SUCCESS_RESPONSE;
			} else {
				result = "Error intentando eliminar el regalo al punto de venta";
			}
			return ok(result);
		} catch (Exception e) {
			Logger.error("Ha ocurrido un error intentando eliminar este regalo del punto de venta \n" + e.getMessage(), e);
			return badRequest("Ha ocurrido un error intentando eliminar este regalo del punto de venta ( " + e.getMessage() + " )");
		}
	}
}

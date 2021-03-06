package com.megift.resources.social.controller;

import static com.megift.resources.utils.Constants.SUCCESS_RESPONSE;

import java.util.Map;

import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import com.megift.bsp.partner.entity.Partner;
import com.megift.bsp.partner.logic.PartnerLogic;
import com.megift.resources.social.logic.SocialLogic;
import com.megift.sec.login.entity.Login;

public class SocialControl extends Controller {

	public static Result inviteFriends() {
		try {
			response().setHeader("Access-Control-Allow-Origin", "*");
			final Map<String, String[]> data = request().body().asFormUrlEncoded();
			String result = "Error al recibir la petición";
			if (data != null) {
				Partner partner = new Partner(new Login(Integer.parseInt(data.get("login-id")[0])));
				if (PartnerLogic.loadPartner(partner)) {
					String emailFriend1 = data.get("email-friend-1")[0];
					String emailFriend2 = data.get("email-friend-2")[0];
					String emails[] = new String[2];
					if (emailFriend1 != null)
						if (!emailFriend1.isEmpty())
							emails[0] = emailFriend1;
					if (emailFriend2 != null)
						if (!emailFriend2.isEmpty())
							emails[1] = emailFriend2;
					if (emails.length > 0) {
						if (SocialLogic.inviteFriendsByEmail(partner, emails)) {
							result = SUCCESS_RESPONSE;
						} else {
							result = "Error al enviar invitaciones por correo";
						}
					} else {
						result = "No hay correos para invitar a tus amigos";
					}
				} else {
					result = "El usuario no existe!";
				}
			}
			return ok(result);
		} catch (Exception e) {
			Logger.error("Ha ocurrido un error intentado invitar amigos \n" + e.getMessage(), e);
			return badRequest("Ha ocurrido un error intentado invitar amigos ( " + e.getMessage() + " )");
		}
	}
}

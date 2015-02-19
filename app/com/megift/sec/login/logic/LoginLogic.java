package com.megift.sec.login.logic;

import com.megift.sec.login.dao.LoginDao;
import com.megift.sec.login.entity.Login;

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
public class LoginLogic {

    /**
     * @param login
     * @return
     */
    public static boolean create(Login login) {
        boolean created = false;
        if (!login.isEmpty()) {
            created = LoginDao.create(login);
        }
        return created;
    }

    /**
     * @param login
     * @return
     */
    public static boolean signIn(Login login) {
        boolean created = false;
        if (!login.isEmpty()) {
            created = LoginDao.signIn(login);
        }
        return created;
    }

}
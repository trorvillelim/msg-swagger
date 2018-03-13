package main.Util;


import main.models.UserSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by orvillelim on 28/09/2017.
 */
public class SessionUtil {

    public static UserSession getUserSession(String key, HttpServletRequest request){
        try{
            HttpSession session = request.getSession();
            return (UserSession) session.getAttribute(key);
        }catch (NullPointerException ex){
            return  null;
        }
    }

}

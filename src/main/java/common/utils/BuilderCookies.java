package common.utils;

import org.openqa.selenium.Cookie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BuilderCookies {
    public static Map<String,String> build(Set<Cookie> cookies){
        Map<String, String> headers = new HashMap<>();
        for(Cookie cookie: cookies){
            System.out.println(cookie.getName()+"  : "+cookie.getValue());
            headers.put(cookie.getName(),cookie.getValue());
        }
        return headers;
    }

}

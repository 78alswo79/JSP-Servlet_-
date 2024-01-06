package util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Cookie2 {
	private Map<String, Cookie> cookieMap = new HashMap<>();

	public Cookie2(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
//		System.out.println("cookies" + cookies);
		// cookies가 존재한다며~
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
//				System.out.println("cookies["+i+"].getName()" + cookies[i].getName());
//				System.out.println("cookies["+i+"]" + cookies[i]);
//				System.out.println("cookies["+i+"]" + cookies[i].getValue());
			}
		}
	}
	
	public Cookie getCookie(String name) {
//		System.out.println("cookieMap.get(name)" + cookieMap.get(name));
		return cookieMap.get(name);
	}
	
	public String getValue(String name) throws IOException{
		Cookie cookie = cookieMap.get(name);
		if (cookie == null) {
			return null;
		} else {
			return URLDecoder.decode(cookie.getValue(), "euc-kr");
		}
	}
	
	// 쿠키가 존재하는지 없는지 비교하는 메소드 만들기
	public boolean exits(String name) {
		return cookieMap.get(name) != null;
	}
	
	public static Cookie createCookie(String name, String value) throws IOException{
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}
	
	public static Cookie createCookie(String name, String value, int maxAge) throws IOException{
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setMaxAge(0);
		return cookie;
	}
	
	
}

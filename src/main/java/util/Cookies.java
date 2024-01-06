package util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Cookies {

	private Map<String, Cookie> cookieMap = 
				new HashMap<>();
	
	// 쿠키 생성자
	public Cookies(HttpServletRequest  req) {
		Cookie[] cookies = req.getCookies();
		System.out.println("cookies" + cookies);
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
				System.out.println("cookies["+i+"].getName()" + cookies[i].getName());
				System.out.println("cookies["+i+"]" + cookies[i]);
			}
		}
	}
	
	// 쿠키 가져오기. 이름
	public Cookie getCookie(String name) {
		System.out.println("cookieMap.get(name)" + cookieMap.get(name));
		return cookieMap.get(name);
	}
	
	// 해당 쿠키 값 가져오기.
	public String getValue(String name) throws IOException {
		Cookie cookie = cookieMap.get(name);
		if (cookie == null) {
			return null;
		}
		System.out.println("cookie.getValue()" + cookie.getValue());
		return URLDecoder.decode(cookie.getValue(), "euc-kr");
	}
	
	public boolean exists(String name) {
		return cookieMap.get(name) != null;	
	}
	
	// 쿠키 생성 메소드
	// 1. 쿠키이름 2. 쿠키 값
	public static Cookie createCookie(String name, String value) throws IOException{
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}
	
	// 쿠키 생성 메소드
	// 1. 쿠키이름 2. 값 3.쿠키 설정 경로 4.쿠키 지속시간
	public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	// 쿠키 생성 메소드
	// 1. 쿠키이름 2. 값 3.쿠키도메인 3.쿠키 설정경로 4.쿠키 지속시간
	public static Cookie createCookie(String name, String value, String domain, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	
}

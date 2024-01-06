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

	// response에 쿠키를 추가 한 뒤에
	// request로 쿠키[]으로 정의 할 수 있다.
	// Map<String, Cookie> 객체를 이용하여
	// "쿠키네임" : "쿠키"로 초기화를 해준다.
	public Cookie2(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookieMap.put(cookies[i].getName(), cookies[i]);
			}
		}
	}
	
	// 해당 네임의 쿠키 가져오기.
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	// 해당 네임의 쿠키값 가져오기.
	public String getValue(String name) throws IOException{
		Cookie cookie = cookieMap.get(name);
		if (cookie == null) {
			return null;
		} else {
			return URLDecoder.decode(cookie.getValue(), "euc-kr");
		}
	}
	
	// 해당 쿠키가 존재유무 메소드
	// 값이 존재한다면 true / 존재하지 않는다면 false
	public boolean exits(String name) {
		return cookieMap.get(name) != null;
	}
	
	// 첫 번째. 쿠키 생성
	// 네임과 벨류값을 받아 쿠키를 생성한다.
	public static Cookie createCookie(String name, String value) throws IOException{
		return new Cookie(name, URLEncoder.encode(value, "utf-8"));
	}
	
	// 두 번째. 쿠키 생성
	// 네임과 벨류값, 유효기간 값을 받아 쿠키를 생성한다.
	public static Cookie createCookie(String name, String value, int maxAge) throws IOException{
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		cookie.setMaxAge(0);
		return cookie;
	}
	
	
}

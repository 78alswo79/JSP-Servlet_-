import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Cookie2;

@WebServlet(urlPatterns = {"/index.do", "/cookie.do"})
public class CookieServlet extends HttpServlet {

	Cookie2 cookie2 = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 쿠키를 생성합니다.
		System.out.println("cookie 서블릿에 오신 것을 환영합니다.");


		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("<div>");
		out.println("<h2 align=\"center\">쿠키 연습용 팝업</h2>");
		out.println("<div>");
		out.println("<form action=\"./popupCheck.do\" method=\"post\">");
		out.println("<input type =\"checkbox\" name = \"popupCheck\" value=\"1\" />\r\n"
				+ "				<input type=\"button\" value=\"닫기\" />");
		out.println("<input type=\"submit\" value=\"확인\" />");
		out.println("</form>");
		out.println("</div>");
		out.println("</div>");
	}
	
}

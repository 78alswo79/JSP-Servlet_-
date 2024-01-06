import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Cookie2;

@WebServlet(urlPatterns = "/popupCheck.do")
public class PopupServlet extends HttpServlet{

	Cookie2 cookie2 = null;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
        process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html; charset=utf-8");
		req.getParameter("popupCheck");

		// checkbox 체크 값.
		String checkVal = req.getParameter("popupCheck");
		
		PrintWriter out = res.getWriter();
		
		// 체크박스 체크를 했으면,
		// 쿠키 만들어주기.
		if ("1".equals(checkVal)) {	
			res.addCookie(
					cookie2.createCookie("popupBool", "close")
			);
			
//			res.addCookie(
//					cookie2.createCookie("popupBool", "close", 0)
//			);
		} 
		
		// 쿠키 요청
		cookie2 = new Cookie2(req);
		
//		System.out.println(cookie2.getCookie("test1"));
//		System.out.println(cookie2.getValue("test1"));
		
		// 요청에 쿠키가 존재한다면
		if (cookie2.exits("popupBool")) 
		{
			out.println("<div>");
			out.println("<h2 align=\"center\">쿠키 값 생성되고 난 후 화면</h2>");
			out.println("<div>");
			out.println("<h3>쿠키가 생성 되어 팝업이 없어졌습니다.!!!");
			out.println("</h3>");
			out.println("</div>");
			out.println("</div>");
		} 
		// 쿠키가 존재하지 않는다면
		else 
		{
			out.println("<div>");
			out.println("<h2 align=\"center\">쿠키 만들어지기 전 화면</h2>");
			out.println("<div>");
			out.println("<form action="+req.getContextPath()+"/popupCheck.do method=post>");
			out.println("<input type =\"checkbox\" name = \"popupCheck\" value=\"1\" />\r\n"
					+ "				<input type=\"button\" value=\"닫기\" />");
			out.println("<input type=\"submit\" value=\"확인\" />");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
		}
	}
}

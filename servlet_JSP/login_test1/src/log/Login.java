package log;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
													throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		PrintWriter out = response.getWriter();
		
		if(id != null && id != "") {
			if(pw != null && pw != "") {
				out.println("아이디 : " +id+"<br>");
				out.println("비밀번호 : "+pw+"<br>");
			}else {
				out.println("비밀번호를 잘못 입력하였습니다.");
			}
		}else {
			out.println("아이디를 잘못 입력하였습니다.");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		doGet(request, response);
		
	}

}

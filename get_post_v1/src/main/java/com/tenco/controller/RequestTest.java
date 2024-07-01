package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//http://localhost:8080/req-test
@WebServlet("/req-test")
public class RequestTest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RequestTest() {
		super();

	}

	// http://localhost:8080/gp/req-test?name="홍길동"
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// METHOD <--- GET방식일떄
		// 요청을 받고 응답시에 MINE TYPE -> text/html
		response.setContentType("text/html; charset=UTF-8");

		// HTTP 요청 메세지에 시작줄에 /req-test?name="홍길동"
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int number = 0;
		try {
			number = Integer.parseInt(age);
			System.out.println(number); // output = 25
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}

		String greeting = "Hello, " + (name != null ? name : "바보") + "  " + number + " !! ";

		response.getWriter().print("<html> <body> <h2>" + greeting + "</h2> </body> </html>");
	}

	
	// http://localhost:8080/gp/req-test
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//요청을 받아서(인증검사,요청값 유효성검사)

		
		
		//HTTP 요청 바디에서 데이터를 추출
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		//보통 db에 접근해서 CRUD작업
		
		response.getWriter().write("<html>");
		response.getWriter().write("<head>");
		response.getWriter().write("</head>");
		response.getWriter().write("<body>");
		response.getWriter().write("<h1>");
		response.getWriter().write("<p>");
		response.getWriter().write("name : " +name);
		response.getWriter().write("<br>");
		response.getWriter().write("email : "+ email);
		response.getWriter().write("</p>");
		response.getWriter().write("</h1>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
		
		//http://localhost:8080/demo1/req-test?name=%22%EA%B9%80%EC%A7%80%EB%8B%88%22
	
	}

}

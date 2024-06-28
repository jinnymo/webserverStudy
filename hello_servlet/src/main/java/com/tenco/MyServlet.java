package com.tenco;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//http://localhost:8080/hello/my-servlet
@WebServlet(name ="MyServlet",urlPatterns = {"/my-servlet"})
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MyServlet() {

		super();
		System.out.println("1");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("sdaf");
	}

	// 클라이언트가 요청시마다 매번 호출이 될까?
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("서비스 매서드 호출 확인");
		response.setContentType("text/html; charset=UTF-8");
		super.service(request, response);
	}

	@Override
	public void destroy() {
		super.destroy();

		System.out.println("destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doget 메서드 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("dopost 메서드 호출");
		
		System.out.println(request.toString());

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().write("<html><body><h1>good</h1></body></html>");
	}

}

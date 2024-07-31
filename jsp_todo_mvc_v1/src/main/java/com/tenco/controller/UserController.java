package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.tenco.model.UserDAO;
import com.tenco.model.UserDAOImpl;
import com.tenco.model.UserDTO;


//주소 설계
// http://localhost:8080/mvc/user
// http://localhost:8080/mvc/user/xxx
@WebServlet("/user/*")
public class UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
	
    public UserController() {
        super();
    }
    @Override
    public void init() throws ServletException {
    	userDAO = new UserDAOImpl();
    }

    // GET 방식으로 들어 올 때
    // http://localhost:8080/mvc/user/signUp
    // http://localhost:8080/mvc/user/signIn
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		
		case "/signIn":
			//로그인 페이지로 보내는 동작 처리
			System.out.println("로그인");
			request.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(request, response);
			break;
			
		case "/signUp":
			//회원가입 페이지로 보내는 동작 처리
			System.out.println("회원가입");
			request.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(request, response);
			break;
			

		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}
	// 로그인 기능 요청( 자원의 요청이라 get방식이 맞지만 로그인 관련은 보안사항이라 예외적으로 
	// post 방식으로 처리)
	// POST 요청시 - 로그인 기능 구현, 회원가입 구현
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getPathInfo();
		switch (action) {
		
		case "/signIn":
			signIn(request,response);
			break;
			
		case "/signUp":
			signUp(request, response);
			break;
			
		default:
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			break;
		}
	}
	/*
	 * 로그인 처리 기능
	 */
	private void signIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 이라서 인증검사 필요 없음
		
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				//방어적 코드 작성
				if (username == null || username.trim().isEmpty()) {
					request.setAttribute("errorMessage", "사용자 이름을 입력하시오");
					request.getRequestDispatcher("/WEB-INF/views/signIN.jsp").forward(request, response);
					return;
				}
				//방어적 코드 작성 (password, email) 생략
				UserDTO user = userDAO.getUserByUsername(username);
				if (user != null && user.getPassword().equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("principal", user);

					response.sendRedirect("/mvc/todo/todoForm");
				}else {
					response.sendRedirect("signIn?message=invalid data");
				}
			
		
	}
	/*
	 * 회원 가입 기능
	 */
	private void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원가입 이라서 인증검사 필요 없음
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//방어적 코드 작성
		if (username == null || username.trim().isEmpty()) {
			request.setAttribute("errorMessage", "사용자 이름을 입력하시오");
			request.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(request, response);
			return;
		}
		//방어적 코드 작성 (password, email) 생략
		
		UserDTO userDTO = UserDTO.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
		
		int resultCount = userDAO.addUser(userDTO);
		System.out.println("resultCount : " + resultCount);
		if (resultCount == 1) {
			response.sendRedirect("signIn?message=success");
		}else {
			response.sendRedirect("signUp?message=register fail");
			
		}
	}
	

}

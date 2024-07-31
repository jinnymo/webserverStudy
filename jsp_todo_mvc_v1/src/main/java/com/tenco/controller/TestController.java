package com.tenco.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.tenco.model.UserDAO;
import com.tenco.model.UserDAOImpl;
import com.tenco.model.UserDTO;

@WebServlet("/test/*")
public class TestController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	public TestController() {
		super();
	}

	@Override
	public void init() throws ServletException {

		userDAO = new UserDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/byId":
			//http://localhost:8080/mvc/test/byId
			//userDAO.getUserById(1);
			//userDAO.getUserByUsername("김동윤");
			//userDAO.getAllUsers();
//			System.out.println(userDAO.deleteUser(4));
			
			UserDTO dto = UserDTO.builder().password("수정").email("수정함").build();
			int count = userDAO.updateUser(dto, 3);
			System.out.println(count);
			break;

		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

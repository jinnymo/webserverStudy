package com.tenco.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tenco.model.TodoDAO;
import com.tenco.model.TodoDAOImpl;
import com.tenco.model.TodoDTO;
import com.tenco.model.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/*")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TodoDAO todoDAO;
    public TodoController() {
    	todoDAO = new TodoDAOImpl();
    }

    //http://localhost:8080/mvc/todo/todoForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/todoForm":
			todoFormPage(request,response);
			break;
		case "/list":
			todoListPage(request,response);
			break;
		case "/delete":
			deleteList(request,response);
			break;
		case "/detail":
			System.out.println("!!!@!@");
			detail(request,response);
			break;
		default:
			break;
		}
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO)session.getAttribute("principal");
		int todoId = Integer.parseInt(request.getParameter("id"));
		TodoDTO todoDTO = todoDAO.getTodoById(todoId,principal.getId());
		//TODO -- 주소창에 주소 강제 작성시 처리
		//todoDTOgetuserid == null 이라면 처리해주면 됨
		if (principal.getId() == todoDTO.getUserId()) {
			request.setAttribute("todoDTO", todoDTO);
			request.getRequestDispatcher("/WEB-INF/views/todoDetail.jsp").forward(request, response);			
		}else {
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out=response.getWriter();
            out.print("<script> alert('권한이 없습니다.'); </script>");
        }
		
		
	}

	private void deleteList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO)session.getAttribute("principal");
		int todoId = Integer.parseInt(request.getParameter("id"));
		todoDAO.deleteTodo(todoId, principal.getId());
		response.sendRedirect("/mvc/todo/list");
	}

	

	private void todoListPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO)session.getAttribute("principal");
		System.out.println(request.getContextPath());
		
		if (principal == null) {
			response.sendRedirect(request.getContextPath()+"/user/signIn?message=invalid");
			return;
		}
		List<TodoDTO> todoDTOList = todoDAO.getTodosByUserId(principal.getId());
		request.setAttribute("todoDTOList", todoDTOList);
		request.getRequestDispatcher("/WEB-INF/views/todoList.jsp").forward(request, response);
		
	}

	private void todoFormPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//로그인한 사용자만 접근을 허용하도록 설계
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO)session.getAttribute("principal");
		
		//인증 검사
		if (principal == null) {
			//로그인을 안한 상태
			response.sendRedirect("/mvc/user/signIn?message=invalid");
		}
		
		request.getRequestDispatcher("/WEB-INF/views/todoForm.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		switch (action) {
		case "/add":
			
			todoAdd(request, response);
			break;
		case "/edit":
			editTodo(request,response);
			break;
		default:
			break;
		}
		
	}

	private void editTodo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO)session.getAttribute("principal");
		Boolean temp1 = false;
		System.out.println("com :" +request.getParameter("completed"));
		if(request.getParameter("completed") == null) {
			temp1 = false;
		}else {
			temp1 = true;
		}
		TodoDTO todo = TodoDTO.builder()
				.id(Integer.parseInt(request.getParameter("id")))
				.title(request.getParameter("title"))
				.description(request.getParameter("description"))
				.dueDate(request.getParameter("dueDate"))
				.completed(temp1)
				.build();
		todoDAO.updateTodo(todo,principal.getId());
		response.sendRedirect("/mvc/todo/list");
	}
	private void todoAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDTO principal = (UserDTO)session.getAttribute("principal");
		Boolean temp1 = false;
		
		if(request.getParameter("completed") == null) {
			temp1 = false;
		}else {
			temp1 = true;
		}
		TodoDTO todo = TodoDTO.builder()
							.title(request.getParameter("title"))
							.description(request.getParameter("description"))
							.dueDate(request.getParameter("dueDate"))
							.completed(temp1)
							.build();
		System.out.println("1211");
		System.out.println(todo.getTitle());
		todoDAO.addTodo(todo,principal.getId());
		System.out.println("추가 잘됨");
		response.sendRedirect("/mvc/todo/list");
		
	}
}

package com.tenco;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class TodoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
   
    public TodoServlet() {
    	
        super();
        
    }
    
    // 주소 설계 - http://localhost:8080/demo_4/todo-servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	System.out.println("get 요청 확인");
	
	Todo todo1 = new Todo();
	todo1.setId(100);
	todo1.setTitle("sdafsdf");
	todo1.setCompleted(false);
	
	response.setContentType("application/json");
	
	
	
	//	String strJson = "{\r\n"
//			+ "  \"userId\": 1,\r\n"
//			+ "  \"id\": 1,\r\n"
//			+ "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\r\n"
//			+ "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\r\n"
//			+ "}";
//	
		PrintWriter pw = response.getWriter();
		pw.print(todo1);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

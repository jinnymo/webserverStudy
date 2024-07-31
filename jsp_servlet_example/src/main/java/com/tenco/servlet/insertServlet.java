package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//@WebServlet("/insert.jsp")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public insertServlet() {
        super();
        
    }

    @Override
    public void init() throws ServletException {
    	System.out.println("InsertServlet 초기화");
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}
	//http://localhost:8080/insertServlet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		//유효성 검사 생략
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/demo5?serverTimezone=Asia/Seoul";
			Connection conn = DriverManager.getConnection(dburl,"root","asd123");
			String sql = " INSERT INTO users(name, email) values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			int a = 0;
			while(a != 2000) {
				pstmt.executeUpdate();
				a++;
			}
		
			pstmt.close();
			conn.close();
			
			response.sendRedirect("result.jsp?message=success");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			response.sendRedirect("result.jsp?message=fail");
		} 
	}

}

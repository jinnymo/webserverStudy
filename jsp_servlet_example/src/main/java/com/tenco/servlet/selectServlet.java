package com.tenco.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public selectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/demo5?serverTimezone=Asia/Seoul";
			Connection conn = DriverManager.getConnection(dburl, "root", "asd123");
			String sql = " SELECT*FROM users ";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			
			List<Map<String,String>> userList = new ArrayList<>();
			while(rs.next()) {
				Map<String, String> userMap = new HashMap();
				userMap.put("id", rs.getString("id"));
				userMap.put("name", rs.getString("name"));
				userMap.put("email", rs.getString("email"));
				
				userList.add(userMap);
			}
			request.setAttribute("userList",userList);
//			String name =rs.getString("name");
//			String email = rs.getString("email");
			request.getRequestDispatcher("resultSet.jsp").forward(request, response);
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

package com.tenco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/delete-post")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletePostServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("boardId");

		try (Connection conn = DBUtil.getConnection()) {
			String sql = " DELETE FROM posts WHERE id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.executeUpdate();

			//http 상태코드 302(임시이동) 사용자에게 새로운 url로 이동처리 치킴
			response.sendRedirect("result.jsp?message=delete-success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response.sendRedirect("result.jsp?message=error");
		}

	}

}

package com.tenco.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.tenco.models.User;

public class UserDaoImpl {

	private static final String URL = "jdbc:mysql://localhost:3306/demo3?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PASSWORD = "asd123";

	public UserDaoImpl() {
		try {
			Class.forName("com.mysql.ch.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try (Connection conn = getConnection()) {
			String sql = " SELECT * FROM users ";
			try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					User user = User.builder()
							.id(rs.getInt("id"))
							.username(rs.getString("username"))
							//.password(rs.getString("password"))
							.email(rs.getString("email"))
							.build();
					users.add(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;

	}

	public int addUser(User user) {
		
//		try (){
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		return 0;
		
	}

}

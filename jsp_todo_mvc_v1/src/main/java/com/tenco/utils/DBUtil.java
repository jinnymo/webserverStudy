package com.tenco.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {

	private static DataSource dataSource;

	static {
		//TODO - 삭제 예정
		System.out.println("111");
		
		
		try {
			// InitialContext 객체를 생성하여 JNDI API 기술을 통해 존재하는 리소스를 찾는 방법
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
}

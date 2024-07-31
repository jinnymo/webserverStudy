package com.tenco.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tenco.utils.DBUtil;

public class UserDAOImpl implements UserDAO {

	private DataSource dataSource;

	public UserDAOImpl() {
		try {
			InitialContext ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/MyDB");
			System.out.println("!!11");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addUser(UserDTO userDTO) {

		String sql = " INSERT INTO users(username, password, email) VALUES (?,?,?) ";
		int resultCount = 0;
		
		try(Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, userDTO.getUsername());
				pstmt.setString(2, userDTO.getPassword());
				pstmt.setString(3, userDTO.getEmail());
				resultCount = pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}//end of preparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		}//end of connection
		
		return resultCount;
	}
	
	/*
	 * select 구문에서는 트랙젝션 처리 하지 말자
	 * 하지만 팬텀리드현성(정합성을 위해서 처리하는것이 옳은 방법이다)
	 */
	@Override
	public UserDTO getUserById(int id) {
		
		String sql = " SELECT * FROM users WHERE id = ? ";
		
		UserDTO userDTO = null;
		try(Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1, id);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					userDTO = UserDTO.builder()
								.id(rs.getInt("id"))
								.username(rs.getString("username"))
								.password(rs.getString("password"))
								.email(rs.getString("email"))
								.createdAt(rs.getString("created_at"))
								.build();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}//end of preparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		}//end of connection
		
		System.out.println(userDTO.toString());
		return userDTO;
	}

	@Override
	public UserDTO getUserByUsername(String username) {

		
		String sql = " SELECT * FROM users WHERE username = ? ";
		
		UserDTO userDTO = null;
		try(Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, username);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					userDTO = UserDTO.builder()
								.id(rs.getInt("id"))
								.username(rs.getString("username"))
								.password(rs.getString("password"))
								.email(rs.getString("email"))
								.createdAt(rs.getString("created_at"))
								.build();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}//end of preparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		}//end of connection
		
		//System.out.println("by username :"+userDTO.toString());
		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUsers() {

		String sql = " SELECT * FROM users ";
		List<UserDTO> userList = new ArrayList<UserDTO>();
		UserDTO userDTO = null;
		try(Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					userDTO = UserDTO.builder()
							.id(rs.getInt("id"))
							.username(rs.getString("username"))
							.password(rs.getString("password"))
							.email(rs.getString("email"))
							.createdAt(rs.getString("created_at"))
							.build();
					userList.add(userDTO);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}//end of preparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		}//end of connection
		
		//TODO 삭제 예정
		System.out.println("userList all : "+ userList.toString());
		return userList;
	}

	@Override
	public int updateUser(UserDTO userDTO, int principalId) {
		String sql = " UPDATE users SET password = ?, email = ? WHERE id = ? ";
		int rowCount = 0;
		
		try(Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, userDTO.getPassword());
				pstmt.setString(2, userDTO.getEmail());				
				pstmt.setInt(3, principalId);
				rowCount = pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}//end of preparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		}//end of connection
		
		return rowCount;
	}

	@Override
	public int deleteUser(int id) {
		String sql = " DELETE FROM users WHERE id = ? ";
		int rowCount = 0;
		
		try(Connection conn = dataSource.getConnection()) {
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1, id);
				rowCount = pstmt.executeUpdate();
				
				conn.commit();
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			}//end of preparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		}//end of connection
		
		return rowCount;
	}

}

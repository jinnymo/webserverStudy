package com.tenco.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TodoDAOImpl implements TodoDAO{

	private DataSource dataSource;
	
	public TodoDAOImpl() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/MyDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void addTodo(TodoDTO dto, int principalId) {
		String sql = " INSERT INTO todos(user_id,title,description, due_date, completed) "
				+ " VALUE(?,?,?,?,?) ";
		
		try (Connection conn = dataSource.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1, principalId);
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getDescription());
				pstmt.setString(4,dto.getDueDate());
				pstmt.setBoolean(5, dto.isCompleted());
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TodoDTO getTodoById(int id, int principalId) {
	
		TodoDTO todoDTO = null;
		String sql = " select * from todos where id = ? and user_id = ?; ";
		
		try (Connection conn = dataSource.getConnection()){
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1, id);
				pstmt.setInt(2, principalId);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					
					todoDTO = TodoDTO.builder()
							.id(rs.getInt("id"))
							.title(rs.getString("title"))
							.description(rs.getString("description"))
							.dueDate(rs.getString("due_date"))
							.completed(rs.getBoolean("completed"))
							.userId(rs.getInt("user_id"))
							.build();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("조회완료");
		
		
		
		return todoDTO;
	}

	@Override
	public List<TodoDTO> getTodosByUserId(int principalId) {
		
		String sql = " SELECT * FROM todos WHERE user_id = ? ";
		List<TodoDTO> todoList = new ArrayList<TodoDTO>();
		TodoDTO todoDTO = null;
		try(Connection conn = dataSource.getConnection()) {
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				System.out.println(principalId);
				pstmt.setInt(1, principalId);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					todoDTO = TodoDTO.builder()
								.id(rs.getInt("id"))
								.title(rs.getString("title"))
								.description(rs.getString("description"))
								.dueDate(rs.getString("due_date"))
								.completed(rs.getBoolean("completed"))
								.build();
					todoList.add(todoDTO);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}//end of preparedStatement
		} catch (Exception e) {
			e.printStackTrace();
		}//end of connection
		
		//TODO 삭제 예정
		//System.out.println("userList all : "+ todoList.toString());
		return todoList;
	}

	@Override
	public List<TodoDTO> getTodosAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTodo(TodoDTO dto, int principalId) {
		
	
		String sql = " UPDATE todos SET title = ?, description =?,due_date=?, completed = ? "
				 + " where id = ? and user_Id = ? ";
		try (Connection conn = dataSource.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getDescription());
				pstmt.setString(3, dto.getDueDate());
				pstmt.setInt(4,dto.isCompleted() ? 1:0);
				pstmt.setInt(5, dto.getId());
				pstmt.setInt(6, principalId);
				
				pstmt.executeUpdate();
				conn.commit();
				
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteTodo(int id, int principalId) {
		String sql = " delete from todos where id = ? and user_id = ?; ";
		
		try (Connection conn = dataSource.getConnection()){
			conn.setAutoCommit(false);
			try (PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setInt(1, id);
				pstmt.setInt(2, principalId);
				pstmt.executeUpdate();
				conn.commit();
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("삭제 완ㄹ요");
		
	}

}

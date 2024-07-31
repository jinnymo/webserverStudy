package com.tenco.model;

import java.util.List;

public interface TodoDAO {

	
	//저장
	void addTodo(TodoDTO dto, int principalId);
	TodoDTO getTodoById(int id,int principalId);
	List<TodoDTO> getTodosByUserId(int principalId);
	List<TodoDTO> getTodosAll();
	void updateTodo(TodoDTO dto, int principalId);
	void deleteTodo(int id, int principalId);


}

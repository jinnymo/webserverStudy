package com.tenco.model;

import java.util.List;

public interface UserDAO {

	int addUser(UserDTO userDTO);
	UserDTO getUserById(int id);
	UserDTO getUserByUsername(String username);
	List<UserDTO> getAllUsers();
	int updateUser(UserDTO userDTO, int principalId); // 권한 (내정보) 인증검사(세션 id)
	int deleteUser(int id);
}

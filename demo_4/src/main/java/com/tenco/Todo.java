package com.tenco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Todo {

	private int id;
	private String title;
	private boolean completed;
	
	@Override
	public String toString() {
		return "{\"id\" : "+id+"}";
		// TODO Auto-generated method stub
	}
	
}

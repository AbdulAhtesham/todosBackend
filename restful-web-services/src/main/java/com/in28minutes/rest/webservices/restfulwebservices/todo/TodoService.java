package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	static List<Todo> todos = new ArrayList<Todo>();
	static int idCounter=0;
	static {
		todos.add(new Todo(++idCounter, "ahtesham721", "Learn Spring Boot", new Date(),false));
		todos.add(new Todo(++idCounter, "ahtesham720", "Learn Spring MVC", new Date(),false));
	todos.add(new Todo(++idCounter, "ahtesham720", "Learn Angular", new Date(),false));
	todos.add(new Todo(++idCounter, "ahtesham720", "Learn Full Stack", new Date(),false));
	todos.add(new Todo(++idCounter, "ahtesham720", "Learn Horse Riding", new Date(),false));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if(todo==null) {
			return null;
		}
		
		if(todos.remove(todo)) {
		return todo;
		}
		return null;
	}
	
	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
	
//	public Todo updateTodo(String description, Date completionDate, long id) {
//		Todo todo = findById(id);
//		if(todo==null) {
//			return null;
//		}
//		
//		todo.setCompletionDate(completionDate);
//		todo.setDescription(description);
//		return todo;
//	}
	
	public Todo save(Todo todo) {
		if(todo.getId()<=0) {
			todo.setId(++idCounter);
			todos.add(todo);
			return todo;
		}else {
			deleteById(todo.getId());
			todos.add(todo);
			return todo;
		}
	}
	
	
}

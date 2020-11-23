package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> findAll(@PathVariable String username){
		return todoService.findAll();
	}

	//Delete a todo for a user
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){
		if(todoService.deleteById(id)!=null){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	

	@GetMapping("/users/{username}/todos/{id}")
	public Todo findTodo(@PathVariable String username,@PathVariable long id){
		return todoService.findById(id);
	}
	
//	@PutMapping("/users/{username}/todos/{id}")
//	public ResponseEntity<Void> updateTodo(@RequestBody TodoUpdateBean updateBean, @PathVariable long id){
//		if(todoService.updateTodo(updateBean.getDescription(), updateBean.getCompletionDate(), id)!=null) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.notFound().build();
//	}
	
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable long id, @PathVariable String username, @RequestBody Todo updateBean){
		Todo todo = todoService.save(updateBean);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> addTodo(@PathVariable String username, @RequestBody Todo addBean){
		Todo todo=todoService.save(addBean);
		
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(todo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

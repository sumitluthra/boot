package com.sumit.boot.controllers;

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

import com.sumit.boot.beans.Todo;
import com.sumit.boot.services.ToDoService;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
public class ToDoController {

	@Autowired
	ToDoService service;

	@GetMapping(value = "/{user}/todos")
	public List<Todo> getAllTodos(@PathVariable String user) {
		return service.findAll(user);
	}

	@GetMapping(value = "/{user}/todos/{id}")
	public Todo getTodo(@PathVariable String user, @PathVariable long id) {
		return service.findById(id);
	}

	@PutMapping(value = "/{user}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String user, @PathVariable long id
			,@RequestBody Todo todo) {
		Todo todoUpdated = service.save(todo);

		return new ResponseEntity<Todo>(todoUpdated,HttpStatus.OK);
	}
	
	@PostMapping(value = "/{user}/todos")
	public ResponseEntity<Todo> saveTodo(@PathVariable String user, @RequestBody Todo todo) {
		Todo toDoAdded = service.save(todo);

		return new ResponseEntity<Todo>(toDoAdded,HttpStatus.OK);
	}

	@DeleteMapping(value = "/{user}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String user, @PathVariable long id) {
		Todo todo = service.deleteById(id);

		if (todo != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
}

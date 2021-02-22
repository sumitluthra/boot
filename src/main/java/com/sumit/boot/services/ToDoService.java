package com.sumit.boot.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sumit.boot.beans.Todo;

@Service
public class ToDoService {
	private static List<Todo> todos = new ArrayList<>();
	private static long idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "sumit", "Learn React + Redux", LocalDate.now().plusDays(2), false));
		todos.add(new Todo(++idCounter, "sumit", "Learn about Microservices",LocalDate.now(), false));
		todos.add(new Todo(++idCounter, "sumit", "Practice Java8", LocalDate.now(), false));
		todos.add(new Todo(++idCounter, "richa", "Learn Dance", LocalDate.now(), false));
	}

	public List<Todo> todoList() {
		return todos;
	}
	
	public List<Todo> findAll(String user) {
		
		return todoList().stream().filter(todo -> todo.getUserName().equals(user)).collect(Collectors.toList());
		
	}

	public Todo deleteById(long id) {

		Todo todo = findById(id);
		if(todo==null)
			return null;
		
		if(todos.remove(todo))
			return todo;
		
		return todo;
	}

	public Todo findById(long id) {
		// TODO Auto-generated method stub
		 Optional<Todo> findAny = todoList().stream().filter(todo -> todo.getId()==id).findAny();
		 
		 return findAny.get();
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		
		return todo;
	}

}

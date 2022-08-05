package com.TodoApp.todoapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.TodoApp.todoapp.entity.Todo;
import com.TodoApp.todoapp.repository.TodoRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    // App running at:
    //  - Local:   http://localhost:8081/
    //  - Network: http://10.0.0.137:8081/
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TodoController {

    private Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoRepository todoRepository;



    @GetMapping("/todos")
    public ResponseEntity<Object> getAllTodos(){
        try {
            Iterable<Todo> todos = todoRepository.findAll();
            return new ResponseEntity<Object>(todos, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Object> getTodoById(@PathVariable("id") Long id) {
        try {
            Todo todo = todoRepository.findById(id).get();
            if (todo != null) {
                return new ResponseEntity<Object>(todo, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/todos")
    public ResponseEntity<Object> createTodo(@RequestBody Todo todo) {
        try {
            Todo savedTodo = todoRepository.save(todo);
            return new ResponseEntity<Object>(savedTodo, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Object> updateTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        try {
            todo.setId(id);
            Todo savedTodo = todoRepository.save(todo);
            return new ResponseEntity<Object>(savedTodo, HttpStatus.OK);
        }   catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<HttpStatus> deleteTodo(@PathVariable("id") Long id) {
        try {
            todoRepository.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }

}

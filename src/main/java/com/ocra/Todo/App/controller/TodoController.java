package com.ocra.Todo.App.controller;

import com.ocra.Todo.App.model.Todo;
import com.ocra.Todo.App.service.TodoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController("/")
public class TodoController {
    TodoService service;
    @Autowired
    public TodoController(TodoService service){
        this.service = service;
    }

    // Add a new todo list
    @PostMapping("/addTodo")
    public Todo addNewTodoList(@RequestBody Todo todo){
        return service.addTodoList(todo);
    }
    // get all todo lists
    @GetMapping("/")
    public List<Todo> getAllTodoList(){
        return service.getAllTodoList();
    }
    // get todo list by id
    @GetMapping("/getTodo/{Id}")
    public Todo getTodoListById(@PathVariable Long Id){
        return service.getTodoById(Id);
    }
    // edit a todo list
    @PutMapping("/editTodo/{Id}")
    // I this instead of ResponseEntity i will add List<Todo>, but it's not good practices
    public ResponseEntity<Todo> editTodoList(@PathVariable Long Id, @RequestBody Todo todo){ // RespondEntity is use for Communicate with react app, it allows to customize the whole body
        Todo todoEdit = service.editTodoList(Id, todo);
        return ResponseEntity.ok(todoEdit);
    }

    // delete the todo list
    @DeleteMapping("/deleteTodo/{Id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable Long Id){
        service.deleteList(Id);
        return ResponseEntity.noContent().build(); // this will provide the clear status that represent not noContent 204
    }

    @PutMapping("/editDesc/{Id}")
    public ResponseEntity<Todo> addMoreDescription(@PathVariable Long Id, @RequestBody Todo todo){
        Todo addDescription = service.addMoreDescription(Id,todo);
        return ResponseEntity.ok(addDescription);
    }

    // update a status by Todo Id reference
    @PutMapping("/editTodo/status/{Id}")
    public ResponseEntity<Todo> updateTodoStatus(@PathVariable Long Id, @RequestBody Todo todo){
        Todo updateStatus = service.updateTodoStatus(Id, todo);
        return ResponseEntity.ok(updateStatus);
    }
}

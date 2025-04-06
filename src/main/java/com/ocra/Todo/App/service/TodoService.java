package com.ocra.Todo.App.service;

import com.ocra.Todo.App.model.Todo;
import com.ocra.Todo.App.repo.TodoInterDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    TodoInterDatabase repoTodoDatabase;
    @Autowired
    public TodoService(TodoInterDatabase  todoInterDatabaseRepo){
        this.repoTodoDatabase = todoInterDatabaseRepo;
    }

    // Get all todo lists
    public List<Todo> getAllTodoList(){
        return repoTodoDatabase.findAll();
    }
    // get todo by ID
    public Todo getTodoById(Long Id){
        return repoTodoDatabase.findById(Id).orElse(null); // be focus
    }
    // add a new todo list
    public Todo addTodoList(Todo todo){
        return repoTodoDatabase.save(todo);
    }

    // edit a todo by id
    public Todo editTodoList(Long Id, Todo todo){
        Todo existId = repoTodoDatabase.findById(Id).orElseThrow(() -> new RuntimeException("ID of todo not found"));
        // i have edit this things for edit the todo
        existId.setTitle(todo.getTitle());
        existId.setStatus(todo.getStatus());
        existId.setDate(todo.getDate());
        return repoTodoDatabase.save(existId);
    }

    // delete a todo list by Id
    public void deleteList(Long Id){
        repoTodoDatabase.deleteById(Id); // this is correct
    }


}

package com.example.Todo.service;

import com.example.Todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos=new ArrayList<>(); // In-memory database
    private static int todoCount=0;

    static {
        todos.add(new Todo(++todoCount,"Learn Spring Boot",false));
        todos.add(new Todo(++todoCount,"Visit Grocery Store",false));
        todos.add(new Todo(++todoCount,"Learn AWS",false));
        todos.add(new Todo(++todoCount,"Swimming",false));
        todos.add(new Todo(++todoCount,"Yoga",false));
    }

    public List<Todo> findAll() { // Business Logic
        return todos;
    }
    public  Todo findbyId(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public void deleteTodo(int id) {
Predicate<? super Todo> predicate = todo -> todo.getId()==id;
todos.removeIf(predicate);
    }

    public void updateTodo(int id,Todo newTodo) {
        //step 1: find todo to be update
        //Step 2: update todo

        Todo todo=findbyId(id);// step 1

        todo.setId(newTodo.getId());
        todo.setTitle(newTodo.getTitle());
        todo.setStatus(newTodo.getStatus());
    }
}

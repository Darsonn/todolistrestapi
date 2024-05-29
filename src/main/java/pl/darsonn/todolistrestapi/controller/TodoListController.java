package pl.darsonn.todolistrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.darsonn.todolistrestapi.model.TodoList;
import pl.darsonn.todolistrestapi.service.TodoListService;

import java.util.List;

@RestController
@RequestMapping("/api/todolists")
public class TodoListController {

    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping
    public List<TodoList> getAllTodoLists() {
        return todoListService.findAllTodoLists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoList> getTodoListById(@PathVariable Long id) {
        return todoListService.findTodoListById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<TodoList> getTodoListByName(@PathVariable String name) {
        return todoListService.findTodoListByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}/{userId}")
    public ResponseEntity<TodoList> getUsersTodoListByName(@PathVariable String name, @PathVariable Long userId) {
        return todoListService.findUsersTodoListByName(name, userId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TodoList createTodoList(@RequestBody TodoList todoList) {
        return todoListService.saveTodoList(todoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoList(@PathVariable Long id) {
        todoListService.deleteTodoList(id);
        return ResponseEntity.ok().build();
    }
}

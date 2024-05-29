package pl.darsonn.todolistrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.darsonn.todolistrestapi.model.TodoList;
import pl.darsonn.todolistrestapi.repository.TodoListRepository;
import pl.darsonn.todolistrestapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListService {
    private final UserRepository userRepository;
    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListService(UserRepository userRepository, TodoListRepository todoListRepository) {
        this.userRepository = userRepository;
        this.todoListRepository = todoListRepository;
    }

    public List<TodoList> findAllTodoLists() {
        return todoListRepository.findAll();
    }

    public Optional<TodoList> findTodoListById(Long id) {
        return todoListRepository.findById(id);
    }

    public Optional<TodoList> findTodoListByName(String name) {
        return todoListRepository.findTodoListByTitle(name);
    }

    public TodoList saveTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    public void deleteTodoList(Long id) {
        todoListRepository.deleteById(id);
    }

    public Optional<TodoList> findUsersTodoListByName(String name, Long userId) {
        return todoListRepository.findTodoListByTitleAndUser_UserId(name, userId);
    }
}

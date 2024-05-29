package pl.darsonn.todolistrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.darsonn.todolistrestapi.model.TodoList;
import pl.darsonn.todolistrestapi.model.User;
import pl.darsonn.todolistrestapi.repository.TodoListRepository;
import pl.darsonn.todolistrestapi.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TodoListRepository todoListRepository;

    @Autowired
    public UserService(UserRepository userRepository, TodoListRepository todoListRepository) {
        this.userRepository = userRepository;
        this.todoListRepository = todoListRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        User savedUser = userRepository.save(user);

        TodoList defaultList = new TodoList();
        defaultList.setTitle("default");
        defaultList.setDescription("Domyślna lista zadań");
        defaultList.setUser(savedUser);
        defaultList.setTasks(Collections.emptyList());

        todoListRepository.save(defaultList);

        return savedUser;
    }

    public Optional<User> updateUser(Long userId, User updatedUser) {
        return userRepository.findById(userId).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword()); // Consider using a password encoder here
            return userRepository.save(user);
        });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}


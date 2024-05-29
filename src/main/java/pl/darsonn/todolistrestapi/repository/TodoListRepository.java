package pl.darsonn.todolistrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.darsonn.todolistrestapi.model.TodoList;

import java.util.Optional;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    Optional<TodoList> findTodoListByTitle(String name);
    Optional<TodoList> findTodoListByTitleAndUser_UserId(String title, Long userId);
}

package pl.darsonn.todolistrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.darsonn.todolistrestapi.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}


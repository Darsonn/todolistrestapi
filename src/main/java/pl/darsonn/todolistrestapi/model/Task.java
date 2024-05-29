package pl.darsonn.todolistrestapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false)
    @JsonBackReference
    private TodoList todoList;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(name = "due_date")
    private String dueDate;

    @Column
    private String author;

    @Column(name = "is_completed", nullable = false)
    private Integer isCompleted;

    public boolean isCompleted() {
        return isCompleted != null && isCompleted == 1;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed ? 1 : 0;
    }
}


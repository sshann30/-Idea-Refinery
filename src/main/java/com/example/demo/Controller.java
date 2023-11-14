import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        Optional<Task> task = tasks.stream().filter(t -> t.getId() == id).findFirst();
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task newTask) {
        newTask.setCreateDate(new Date());
        tasks.add(newTask);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task updatedTask) {
        Optional<Task> existingTask = tasks.stream().filter(t -> t.getId() == id).findFirst();

        if (existingTask.isPresent()) {
            Task taskToUpdate = existingTask.get();
            taskToUpdate.setTitle(updatedTask.getTitle());
            taskToUpdate.setDescription(updatedTask.getDescription());
            taskToUpdate.setCompleted(updatedTask.isCompleted());
            taskToUpdate.setCompletionDate(updatedTask.getCompletionDate());
            return ResponseEntity.ok(taskToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
package todolist.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
public class TodoController {

    private TodoService todoService;

    public TodoController() {
    }

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @PostMapping("")
    public ResponseEntity createTodo(@RequestBody Todo todo) {
        Todo created_todo = todoService.create(todo);
        return ResponseEntity.created(URI.create("/todos/"+ created_todo.getId().toString())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        todoService.update(id, todo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}

package todolist.todo;


import todolist.exceptions.ResourceAlreadyExistsException;
import todolist.exceptions.ResourceNotFoundException;

import java.util.List;

public interface TodoService {

    List<Todo> getAll();

    Todo getById(Long id);

    Todo create(Todo newTodo) throws ResourceAlreadyExistsException;

    Todo update(Long id, Todo updatedTodo) throws ResourceNotFoundException;

    boolean delete(Long id) throws ResourceNotFoundException;

}

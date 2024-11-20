package todolist.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import todolist.exceptions.ResourceAlreadyExistsException;
import todolist.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jpa")
public class TodoJPAService implements TodoService {


    private TodoRepository todoRepository;

    @Autowired
    public TodoJPAService(TodoRepository todoRepository){
        this.todoRepository=todoRepository;
    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getById(Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            return todo.get();
        } else {
            throw new ResourceNotFoundException("Todo", id);
        }
    }

    @Override
    public Todo create(Todo newTodo) throws ResourceAlreadyExistsException {
        try {
            todoRepository.findById(newTodo.getId());
            throw new ResourceAlreadyExistsException("Todo", newTodo.getId());
        } catch (ResourceNotFoundException e) {
            todoRepository.save(newTodo);
            return newTodo;
        }
    }


    @Override
    public Todo update(Long id, Todo updatedTodo) throws ResourceNotFoundException {
        Optional<Todo> found = todoRepository.findById(id);
        if(found.isPresent()){
            Todo todo = found.get();
            todoRepository.delete(todo);
            todoRepository.save(updatedTodo);
            return updatedTodo;
        }
        else{
            throw new ResourceNotFoundException("Todo", updatedTodo.getId());
        }


    }

    @Override
    public boolean delete(Long id) throws ResourceNotFoundException {
        Optional<Todo> found = todoRepository.findById(id);
        if(found.isPresent()){
            todoRepository.deleteById(id);
            return true;
        }
        else {
            throw new ResourceNotFoundException("Todo", id);
        }

    }

}

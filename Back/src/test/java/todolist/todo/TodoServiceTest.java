package todolist.todo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import todolist.exceptions.ResourceAlreadyExistsException;
import todolist.exceptions.ResourceNotFoundException;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(classes=TodoJPAService.class)
public class TodoServiceTest {
    @Autowired
    private TodoService todoService;

    @MockBean
    private TodoRepository todoRepository;
    private List<Todo> todos;

    @BeforeEach
    void setUp() {
        todos = new ArrayList<>(){{
           add(new Todo(1L,"Test1", Statut.ACCOMPLIE ,"C'est le test numéro 1", Timestamp.from(Instant.now())));
           add(new Todo(2L, "Test2", Statut.ENCOURS ,"C'est le test numéro 2", Timestamp.from(Instant.now())));
           add(new Todo(3L, "Test3", Statut.ENCOURS ,"C'est le test numéro 3", Timestamp.from(Instant.now())));
        }};
        when(todoRepository.findAll()).thenReturn(todos);
    }

    @Test
    void whenGettingAll_shouldReturn3() {
        assertEquals(3, todoService.getAll().size());
    }

    @Test
    void whenGettingById_shouldReturnIfExists_andBeTheSame() {
        when(todoRepository.findById(1L)).thenReturn((Optional.of(todos.get(0))));
        when(todoRepository.findById(12L)).thenReturn((Optional.empty()));
        assertAll(
                () -> assertEquals(todos.get(0), todoService.getById(1L)),
                () -> assertThrows(ResourceNotFoundException.class, () -> todoService.getById(12L))
        );
    }

    @Test
    void whenCreating_ShouldReturnSame() {
        Todo toCreate = new Todo(6L, "Test6",Statut.ACCOMPLIE ,"C'est le test numéro 4", Timestamp.from(Instant.now()));
        assertEquals(toCreate, todoService.create(toCreate));
    }

    @Test
    void whenCreatingWithSameId_shouldReturnEmpty() {
        Todo same_todo = todos.get(0);

        assertThrows(ResourceAlreadyExistsException.class, ()->todoService.create(same_todo));
    }

    @Test
    void whenUpdating_shouldModifyTodo() {
        Todo initial_todo = todos.get(2);
        Todo new_todo = new Todo(initial_todo.getId(), "Test2Update", initial_todo.getStatut(),initial_todo.getContenu(),Timestamp.from(Instant.now()));

        todoService.update(new_todo.getId(), new_todo);
        Todo updated_todo = todoService.getById(initial_todo.getId());
        assertEquals(new_todo, updated_todo);
        assertTrue(todoService.getAll().contains(new_todo));
    }

    @Test
    void whenUpdatingNonExisting_shouldThrowException() {
        Todo untodo = todos.get(2);

        assertThrows(ResourceNotFoundException.class, ()->todoService.update(75L, untodo));
    }

    @Test
    void whenDeletingExistingTodo_shouldNotBeInTodosAnymore() {
        Todo todo = todos.get(1);
        Long id = todo.getId();

        todoService.delete(id);
        assertFalse(todoService.getAll().contains(todo));
    }

    @Test
    void whenDeletingNonExisting_shouldThrowException() {
        Long id = 68L;

        assertThrows(ResourceNotFoundException.class, ()->todoService.delete(id));
    }

}

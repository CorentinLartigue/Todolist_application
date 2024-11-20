package todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import todolist.todo.Statut;
import todolist.todo.Todo;
import todolist.todo.TodoRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Autowired
	private TodoRepository todoRepository;



	@Bean
	public CommandLineRunner setUpBDD() {
		return (args) -> {

			Todo t1 = new Todo (1L, "Test1", Statut.ACCOMPLIE ,"C'est le test numéro 1", Timestamp.from(Instant.now()));
			Todo t2 = new Todo(2L, "Test2", Statut.ENCOURS ,"C'est le test numéro 2", Timestamp.from(Instant.now()));
			List<Todo> todos = new ArrayList<>(){{
				add(t1);
				add(t2);
				add(new Todo(3L, "Test3", Statut.ENCOURS ,"C'est le test numéro 3", Timestamp.from(Instant.now())));


			}};
			todoRepository.saveAll(todos);

		};
		}


}

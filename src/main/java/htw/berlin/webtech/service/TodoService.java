package htw.berlin.webtech.service;

import htw.berlin.webtech.model.Todo;
import htw.berlin.webtech.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    // @Autowired ist hier nicht notwendig
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todo) {
        if (todoRepository.existsById(id)) {
            todo.setId(id);
            return todoRepository.save(todo);
        } else {
            throw new IllegalArgumentException("Todo not found with id " + id);
        }
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
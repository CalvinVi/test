package htw.berlin.webtech;

import htw.berlin.webtech.controller.TodoController;
import htw.berlin.webtech.model.Todo;
import htw.berlin.webtech.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TodoControllerTests {

    private TodoService todoService;
    private TodoController todoController;

    @BeforeEach
    void setUp() {
        todoService = mock(TodoService.class);
        todoController = new TodoController(todoService);
    }

    @Test
    void testGetTodos() {
        List<Todo> todos = Collections.singletonList(new Todo());
        when(todoService.getAllTodos()).thenReturn(todos);

        ResponseEntity<List<Todo>> response = todoController.getTodos();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(todos, response.getBody());
        verify(todoService, times(1)).getAllTodos();
    }
}
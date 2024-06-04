package htw.berlin.webtech.repository;

import htw.berlin.webtech.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
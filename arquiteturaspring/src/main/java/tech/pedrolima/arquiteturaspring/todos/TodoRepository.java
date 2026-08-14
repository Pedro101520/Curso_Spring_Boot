package tech.pedrolima.arquiteturaspring.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Aqui eu passo o nome da classe da entidade e o tipo do ID
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
}

package tech.pedrolima.libraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.pedrolima.libraryapi.model.Autor;

import java.util.UUID;

// Aqui é basicamente o acesso que o JPA disponibiliza para a manipulação da tabela do banco de dados, então eu passei a classe e o tipo do ID
public interface AutorRepository extends JpaRepository<Autor, UUID> {
}

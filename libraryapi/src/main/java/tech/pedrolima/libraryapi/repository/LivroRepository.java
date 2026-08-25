package tech.pedrolima.libraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.pedrolima.libraryapi.model.Livro;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}

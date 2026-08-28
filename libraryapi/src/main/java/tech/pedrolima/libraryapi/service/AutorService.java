package tech.pedrolima.libraryapi.service;

import org.springframework.stereotype.Service;
import tech.pedrolima.libraryapi.model.Autor;
import tech.pedrolima.libraryapi.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository repository;

    // Injeção de dependência
    public AutorService(AutorRepository repository){
        this.repository = repository;
    }

    // Aqui eu chamo para salvar o objeto no banco de dados
    public Autor salvar (Autor autor){
        return repository.save(autor);
    }
}

package tech.pedrolima.libraryapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.pedrolima.libraryapi.model.Autor;
import tech.pedrolima.libraryapi.model.GeneroLivro;
import tech.pedrolima.libraryapi.model.Livro;
import tech.pedrolima.libraryapi.repository.AutorRepository;
import tech.pedrolima.libraryapi.repository.LivroRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public void atualizacaoSemAtualizar(){
        var livro = livroRepository
                .findById(UUID.fromString("c3d44c5d-aa9d-4a67-8615-3c637d782c6b"))
                .orElse(null);

        livro.setDataPublicacao(LocalDate.of(2024, 6, 1));

        // Não precisa do save, pois já estou no contexto da transação
    }

    @Transactional
    public void executar(){
        // Salva o livro
        Livro livro = new Livro();
        livro.setIsbn("41385-29564");
        livro.setPreco(BigDecimal.valueOf(800));
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setTitulo("Quinto Livro");
        livro.setDataPublicacao(LocalDate.of(2000, 5, 4));

        // Salva o autor
        Autor autor = new Autor();
        autor.setNome("Pedro");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(2003, 1, 7));

        autorRepository.save(autor);

        livro.setAutor(autor);

        livroRepository.save(livro);

        // Simulando um erro para ver o rollback
        if (autor.getNome().equals("Edilson")){
            throw  new RuntimeException("Rollback");
        }
    }
}

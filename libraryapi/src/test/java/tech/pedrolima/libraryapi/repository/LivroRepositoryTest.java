package tech.pedrolima.libraryapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.pedrolima.libraryapi.model.Autor;
import tech.pedrolima.libraryapi.model.GeneroLivro;
import tech.pedrolima.libraryapi.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
// Não precisa ser publico nem a classe e nem os metodos, pq é teste e não vou chamar em canto nenhum
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    // Aqui vou salvar um livro no banco de dados, mas como ele se relaciona com a tabela de autores, eu devo buscar pelo id o objeto do autor
    @Test
    void salvarTest(){
        Livro livro = new Livro();

        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        // Lembrando que eu defini na entidade essa coluna com o tipo de enum
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        // Aqui é onde eu faço a busca do objeto autor para passar no relacionamento
        Autor autor = autorRepository.findById(UUID.fromString("902d00a3-1f00-4a18-b615-adabd5a83e0a")).orElse(null);

        livro.setAutor(autor);

        repository.save(livro);
    }
}
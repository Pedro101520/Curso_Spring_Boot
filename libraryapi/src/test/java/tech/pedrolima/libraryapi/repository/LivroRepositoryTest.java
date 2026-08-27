package tech.pedrolima.libraryapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.pedrolima.libraryapi.model.Autor;
import tech.pedrolima.libraryapi.model.GeneroLivro;
import tech.pedrolima.libraryapi.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
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
        livro.setTitulo("Alegria");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        // Aqui é onde eu faço a busca do objeto autor para passar no relacionamento
        Autor autor = autorRepository.findById(UUID.fromString("902d00a3-1f00-4a18-b615-adabd5a83e0a")).orElse(null);

        livro.setAutor(autor);

        repository.save(livro);
    }

    // Usando cascade
    @Test
    void salvarCascadeTest(){
        Livro livro = new Livro();

        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        // Lembrando que eu defini na entidade essa coluna com o tipo de enum
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        Autor autor = new Autor();
        autor.setNome("João");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1951, 1, 31));

        autorRepository.save(autor);

        livro.setAutor(autor);

        repository.save(livro);
    }

    // Atualizando o autor do livro
    @Test
    void atualizarAutorDoLivro(){
        // Busquei o livro
        var livroParaAtualizar = repository.findById(UUID.fromString("2678561b-d7f2-430a-a157-4efa0c64f88c")).orElse(null);

        // Busco o objeto do tipo autor que seja correspondente ao autor
        Autor autor = autorRepository.findById(UUID.fromString("902d00a3-1f00-4a18-b615-adabd5a83e0a")).orElse(null);

        // Aplico a atualização
        livroParaAtualizar.setAutor(autor);

        repository.save(livroParaAtualizar);
    }

    // Deletando um livro
    @Test
    void deletar(){
        UUID id = UUID.fromString("902d00a3-1f00-4a18-b615-adabd5a83e0a");
        repository.deleteById(id);
    }

    // Buscando informações do livro
    @Test
    void buscarLivroTest(){
        UUID id = UUID.fromString("2678561b-d7f2-430a-a157-4efa0c64f88c");
        Livro livro = repository.findById(id).orElse(null);
        System.out.println("Livro:");
        System.out.println(livro.getTitulo());

        System.out.println("Autor:");
        System.out.println(livro.getAutor().getNome());
    }

    // Eu criei um novo metodo la na classe do repositório do livro, ai eu vou sar aqui
    @Test
    void pesquisarPorTituloTest(){
        // Isso significa que vai me retornar todas as ocorrências que tiverem esse titulo
        List<Livro> lista = repository.findByTitulo("UFO");
        lista.forEach(System.out::println);
    }

    // Como eu escrevi no Repositório do livro, tem como fazer uma consulta usando mais de um parâmetro, e no método abaixo vou aplicar isso
    @Test
    void pesquisarPorTituloEPrecoTest(){
        var preco = BigDecimal.valueOf(100.00);
        List<Livro> lista = repository.findByTituloAndPreco("UFO", preco);
        lista.forEach(System.out::println);
    }


}
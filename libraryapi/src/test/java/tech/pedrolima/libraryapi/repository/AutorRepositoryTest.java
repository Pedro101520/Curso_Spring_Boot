package tech.pedrolima.libraryapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.pedrolima.libraryapi.model.Autor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

// Esse código é apenas para testar os metodos de ações no banco de dados
// Inicio de entendimento de testes unitários
@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    // Salvando um novo registro
    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("Clara");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1951, 8, 10));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor salvo: " + autorSalvo);
    }

    // Atualizando um novo registro
    @Test
    public void atualizarTest(){
        var id = UUID.fromString("9c35c075-c57c-4582-9dbb-7bbf54a64257");

        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()){
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor: \n");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1960, 1, 30));

            repository.save(autorEncontrado);
        }
    }

    // Listando todos os valores
    @Test
    public void listarTest(){
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    // Exibindo a contagem de quantos elementos que tem
    @Test
    public void countTest(){
        System.out.println("Contagem de autores: " + repository.count());
    }

    // Excluindo um autor por id
    @Test
    public void deletePorIdTest(){
        var id = UUID.fromString("9c35c075-c57c-4582-9dbb-7bbf54a64257");
        repository.deleteById(id);
    }

    // Deletando por objeto
    @Test
    public void deleteTest(){
        var id = UUID.fromString("fd571ef4-a878-4e1f-8c7f-0eb62626050e");
        var clara = repository.findById(id).get();
        repository.delete(clara);
    }
}

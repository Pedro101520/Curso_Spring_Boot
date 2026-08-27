package tech.pedrolima.libraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.pedrolima.libraryapi.model.Livro;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {

    // Como pode ter mais de uma ocorrência no retorno, então uso o list
    List<Livro> findByTitulo(String titulo);

    // Além do And tbm tem o Or, ou seja eu posso aplicar as regras que forem necessárias para o desenvolvimento
    // Legal que tem como fazer mais desses métodos de query, e tbm tem como aplicar mais de uma condição para a aplicação das buscas
    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    // Tem muito mais funções do SQL que eu posso adicionar aqui (Para os casos que não estão listadas, tipo as duas funções de livro que adicionei acima)

    // Eu copiei no caderno a forma com @Query, é basicamente quando eu escrevo em SQL (JPQL) e atribuo a consulta ao método
    // Isso é muito usado quando quero fazer uma consulta muito complexa, e ficaria muita coisa se eu fosse escrever da forma comum do JPA
}

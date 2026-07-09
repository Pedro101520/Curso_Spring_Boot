package tech.pedrolima.produtosAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.pedrolima.produtosAPI.model.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

    // Aqui estou a implementar um método a mais, que vai servir para realizar buscas por nome, é a mesma coisa de um select com where
    // Ai só de estar assim, é só chamar la no controller
    List<Produto> findByNome(String nome);

}

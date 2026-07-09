package tech.pedrolima.produtosAPI.controller;

import org.springframework.web.bind.annotation.*;
import tech.pedrolima.produtosAPI.repository.ProdutoRepository;
import tech.pedrolima.produtosAPI.model.Produto;

import java.util.List;
import java.util.UUID;

// Descobri que tem sobrescrita com Metodos HTTP tbm, podem ter a mesma rota, mas se mudar o tipo da requisição ai sobrescreve

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    // Ai eu vou implementar a interface do Jpa própria para o Produto que eu criei no Repository usando injeção de dependência
    private ProdutoRepository produtoRepository;

    // Ai como é interface eu vou usar os metodos do contrato
    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    // Aqui é opcional definir uma rota, pois tem apenas esse método
    // O JPA sabe onde salvar, pois na entidade produto eu passei o nome da tabela, e nas configs do banco de dados
    // o nome da tabela esta igual
    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido: " + produto);

        // Definindo o ID
        var id = UUID.randomUUID().toString();
        produto.setId(id);

        // salvando no banco de dados com o JPA
        produtoRepository.save(produto);
        return produto;
    }

    // configurando a rota de GET
    // Aqui eu busco o resultado por ID no banco de dados, e espero o recebimento de um id
    // aqui é o id passando direto no endpoint
    @GetMapping("/{id}")
    // O PathVariable indica para o Spring que essa rota tem que receber um ID
    public Produto obterPorId(@PathVariable("id") String id){
        // Se não achar retorna nulo
        return produtoRepository.findById(id).orElse(null);
    }

    // Configurando a rota de delete
    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    // configurando a rota de atualizacao
    // Vão ser dois parametros, pois um vai ser o Id que vai servir para a identificação e o outro para o acessos dos dados
    // que serão atualizados no banco de dados
    @PutMapping("/{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
    }

    // Esse ta com olista, pois vai retornar todas as ocorrencias que tiver
    // Esse RequestParam que ta aqui é como se fosse um WHERE do SQL
    // Ai eu uso ele no endpoint, por exemplo: ?name=pedro
    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        // Eu criei esse pq é um específico
        return produtoRepository.findByNome(nome);
    }
}

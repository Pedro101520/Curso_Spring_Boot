package tech.pedrolima.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController  {

    // Injeção de dependência
    private TodoService service;

    public TodoController(TodoService service){
        this.service = service;
    }

    // Recebo um objeto do tipo TodoEntity via corpo da requisição e salvo
    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        try{
            return this.service.salvar(todo);
        }catch (IllegalAccessError e){
            var mensagemErro = e.getMessage();
            throw  new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    // Aqui eu recebo o PathVariable que é para fazer o filtro com o id (Passado pelo endpoint) e recebo pelo Json via corpo da requisição com o RequestBody
    @PutMapping("{id}")
    public void atualizarStatus(
            @PathVariable("id") Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);
        service.atualizarStatus(todo);
    }

    // Fazendo a busca por ID - Vale notar que tem o mesmo caminho que é o ID do que o od atualizar, mas da certo, pois se diferencia por conta da configuração de ambos, onde um é PUT e o outro é GET
    @GetMapping("{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }

}

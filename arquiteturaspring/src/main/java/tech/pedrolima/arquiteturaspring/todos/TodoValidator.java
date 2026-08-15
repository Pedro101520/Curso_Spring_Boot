package tech.pedrolima.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository){
        this.repository = repository;
    }

    public void validar(TodoEntity todo){
        if(existeTodoComDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe um TODO com esta descricao");
        }
    }

    private boolean existeTodoComDescricao(String descricao){
        // Aqui eu to usando o metodo que eu criei lá no código de instancia do JPA que é gerenciado pelo Spring Boot
        return repository.existsByDescricao(descricao);
    }

}

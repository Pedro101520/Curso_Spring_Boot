package tech.pedrolima.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    // Lembrando que atraves do construtor que é feita a injeção de dependencia
    public TodoService(TodoRepository todoRepository, TodoValidator validator, MailSender mailSender){

        this.repository = todoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    // Aqui eu to recebendo um objeto do tipo TodoEntity, o que significa que vai ter todos os atributos da classe, com exceção do id que é gerenciado pelo proprio banco de dados
    public TodoEntity salvar(TodoEntity novoTodo){
        // Aqui eu to usando o metodo que eu criei e deixei o spring gerenciar por mim. Ele basicamente verifica se o todo que o usuario ta tentando cadastrar ja existe
        // Como o validar lança uma exceção se já existir, eu vou tratar isso lá no controller correspondente
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
        mailSender.enviar("Todo " + todo.getDescricao() + " foi alterado para: " + status);
    }

    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

}

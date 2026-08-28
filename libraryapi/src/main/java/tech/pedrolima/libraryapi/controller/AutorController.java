package tech.pedrolima.libraryapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.pedrolima.libraryapi.controller.dto.AutorDTO;
import tech.pedrolima.libraryapi.model.Autor;
import tech.pedrolima.libraryapi.service.AutorService;

import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutorController {

    // Injetando a classe de AutorService, vai servir para eu salvar as informações no banco de dados
    private final AutorService service;

    public AutorController(AutorService service){
        this.service = service;
    }

    // Endpoint que salva um autor (Ou seja, os parametros de entrada são do tipo autor, pois vou salvar as informações dele no banco de dados)
    // Ai como eu expliquei na classe do DTO, eu uso o DTO para fazer o acesso dos atributos da entidade, sem exibir todos os atributos que fazem parte da classe
    // E como eu não quero que o usuário tenha que informar todos os atributos (Como por exemlplo o ID, ou a data de criação do perfil), então eu uso o DTO para pedir aqui no POST, apenas as informações realmente necessárias
    // Tbm vou usar o @RequestBody, para que as informações de entrada de dados para o POST, sejam fornecidas através do body da requisição
    @PostMapping
    // O ResponseEntity serve para o retorno no padrão de API Rest, ou seja, um retorno com o a mensagem e o código
    public ResponseEntity<Void> salvar(@RequestBody AutorDTO autor){
        // Pegando o objeto autor
        Autor autorEntidade = autor.mapearParaAutor();
        service.salvar(autorEntidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(autorEntidade.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}

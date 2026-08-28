package tech.pedrolima.libraryapi.controller.dto;

import tech.pedrolima.libraryapi.model.Autor;

import java.time.LocalDate;

// Serve para a transferência de dados, sem que seja necessário a exibição de todos os atributos da entidade
// Nesse caso, eu vou usar o DTO, pois na tabela do autor, eu tenho muitas informações, mas as que eu realmente preciso, são apenas as 3 que vou passar como parâmetro
public record AutorDTO(
        String nome,
        LocalDate dataNascimento,
        String nacionalide
    ) {

    // Transformando o DTO em um autor. É aqui também que eu defino as outras informações (Caso não tenha informado), então é aqui onde eu transformo o DTO em um objeto definitivo
    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalide);
        return autor;
    }
}

package tech.pedrolima.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

// Aqui as configurações que eu vou passar pro JPA devem ser iguais as que estão na tabela do banco de dados
@Entity
@Table(name = "autor")
// Uma coisa bem legal, com a dependencia lombok que eu coloquei no pom, agora eu posso colocar as anotações abaixo que ele cria os getters e setters dos atributos da entidade em tempo de compilação
@Getter
@Setter
public class Autor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String noem;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;
}

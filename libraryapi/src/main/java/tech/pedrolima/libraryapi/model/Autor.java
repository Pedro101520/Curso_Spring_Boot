package tech.pedrolima.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// Aqui as configurações que eu vou passar pro JPA devem ser iguais as que estão na tabela do banco de dados
@Entity
@Table(name = "autor")
// Uma coisa bem legal, com a dependencia lombok que eu coloquei no pom, agora eu posso colocar as anotações abaixo que ele cria os getters e setters dos atributos da entidade em tempo de compilação
@Getter
@Setter
@ToString
public class Autor {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    // A tabela de Autor não tem essa coluna, mas eu defini aqui o relacionamento entre o autor e livro, apenas para facilitar o acessos das informações entre autor e livro
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    // Aqui vou definir os construtores, mas vou precisar definir um vazio para uso exclusivo do Framework
    @Deprecated
    public Autor(){
    }

    public Autor(UUID id, String nome, LocalDate dataNascimento, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
    }
}

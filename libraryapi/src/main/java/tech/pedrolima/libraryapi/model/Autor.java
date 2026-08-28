package tech.pedrolima.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

// Aqui as configurações que eu vou passar pro JPA devem ser iguais as que estão na tabela do banco de dados
@Entity
@Table(name = "autor")
// Uma coisa bem legal, com a dependencia lombok que eu coloquei no pom, agora eu posso colocar as anotações abaixo que ele cria os getters e setters dos atributos da entidade em tempo de compilação
@Getter
@Setter
@ToString
// Ele fica "escutando" a execução, e verifica se tem as anotations de createdDate e lastModified, ai para que funcione além de aplicar as modificações nesse código
// deve-se aplicar uma anotation na classe de Application
@EntityListeners(AuditingEntityListener.class)
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


    // As anotações de @CreatedDate e LastModifiedDate, preenchem automáticamente os campos no banco de dados, sem a necessidade que eu precise fazer a inclução

    // Informações novas que não são requisitadas no body do DTO
    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "id_usuario")
    private UUID idUsuario;

    // A tabela de Autor não tem essa coluna, mas eu defini aqui o relacionamento entre o autor e livro, apenas para facilitar o acessos das informações entre autor e livro
    @OneToMany(mappedBy = "autor")
//    @Transient
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

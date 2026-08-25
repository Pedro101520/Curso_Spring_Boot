package tech.pedrolima.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
// Esse decorator do Lomok traz as funções padrões do java (Equals, hash, get, set, toString...)
@Data
public class Livro {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    // Aqui eu passei o tipo sendo o objeto do enum, e isso significa que só poderá ser incluido informações que sejam do tipo desse objeto (Ou seja, apenas valores que estejam dentro do enum)
    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;

    // Definindo o relacionamento entre tabelas
    // O cascade é pouco usado
    @ManyToOne // (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;

}

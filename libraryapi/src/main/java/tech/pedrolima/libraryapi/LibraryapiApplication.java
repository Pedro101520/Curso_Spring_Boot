package tech.pedrolima.libraryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.pedrolima.libraryapi.model.Autor;
import tech.pedrolima.libraryapi.repository.AutorRepository;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {
		// Chamando aqui para testar
//		SpringApplication.run(LibraryapiApplication.class, args);


		var context = SpringApplication.run(LibraryapiApplication.class, args);
		AutorRepository repository = context.getBean(AutorRepository.class);

		exemploSalvarRegistro(repository);
	}

	// Fazendo um teste de conexão com o banco de dados
	public static void exemploSalvarRegistro(AutorRepository autorRepository){
		// O legal disso, é que como eu defini as informações com a entidade, então eu devo instanciar o repository e passar os atributos do objeto Autor (Aceita null pq eu defini o tido de refêrencia)
		Autor autor = new Autor();
		autor.setNome("Pedro");
		autor.setNacionalidade("Brasileiro");
		autor.setDataNascimento(LocalDate.of(1950, 1, 31));

		var autorSalvo = autorRepository.save(autor);
		System.out.println("Autor salvo: " + autorSalvo);
	}

}

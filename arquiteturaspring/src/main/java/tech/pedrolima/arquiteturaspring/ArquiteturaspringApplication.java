package tech.pedrolima.arquiteturaspring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArquiteturaspringApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ArquiteturaspringApplication.class, args);

		// Instanciando o runner do programa (Faz a mesma coisa do código acima, mas aqui eu posso adicionar algumas configurações adicionais)
		SpringApplication builder = new SpringApplication(ArquiteturaspringApplication.class);

		// Desliga aquele nome do Spring no terminal quando roda o programa
		builder.setBannerMode(Banner.Mode.OFF);

		builder.run(args);

	}

}

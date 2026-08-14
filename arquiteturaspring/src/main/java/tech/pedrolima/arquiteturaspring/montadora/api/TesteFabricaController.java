package tech.pedrolima.arquiteturaspring.montadora.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pedrolima.arquiteturaspring.montadora.CarroStatus;
import tech.pedrolima.arquiteturaspring.montadora.Chave;
import tech.pedrolima.arquiteturaspring.montadora.HondaHRV;
import tech.pedrolima.arquiteturaspring.montadora.Motor;

@RestController
@RequestMapping("/carros")
public class TesteFabricaController {

    // Eu criei um Bean na classe MontadoraConfiguration, onde eu defino um objeto, o qual eu posso usar via injeção de dependencia
    // em outras classe, como por exemplo nessa que vou aplicar isso - A injeção de dependencia, evita de eu ficar criando objetos com new toda hora
    @Autowired
    @Qualifier("motor")
    private Motor motor;

    // Só lembrando que o @RequestBody, faz com que eu passe os valores via JSON (Como o exemplo que ta no Postman)
    @PostMapping
    // A classe chave é uma entity, então vou receber nesse metodo via API Post informações do objeto Chave
    public CarroStatus ligarCarro(@RequestBody Chave chave){
        // Aqui eu crio o objeto HondaHRV que extende de carro - Por escolha do professor do curso,
        // a classe Carro precisa apenas do parametro do tipo Motor no construtor, por isso que eu estou passando apenas o Motor aqui
        // as demais informações ele definiu via setter mesmo (Mas eu poderia ter passado no construtor, ai nesse caso eu teria que inficar essas informações auqi, acredito que ele fez isso, para não ter que ficar digitando tantas informações)
        HondaHRV carro = new HondaHRV(motor);

        // Aqui eu tinha que acessar o metodo da classe Carro que pode ser acessado pela classe filha HondaHRV
        // depois que eu acessei e passei os dados pelo construtor eu chemei darIgnicao que vai fazer uma comparacao com os dados
        // indicados via JSON pelo usuario e pelos dados do motor que foram acessados nessa classe via injecao de dependencia
        return carro.darIgnicao(chave);
    }

}

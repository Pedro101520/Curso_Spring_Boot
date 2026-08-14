package tech.pedrolima.arquiteturaspring.montadora.configuration;

// Essa classe vai servir como uma classe de criação de Beans que são basicamente objetos gerenciados pelo Spring
// Onde apos a configuracao eu posso manipular eles entre classes sem usar o new

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.pedrolima.arquiteturaspring.montadora.Motor;
import tech.pedrolima.arquiteturaspring.montadora.TipoMotor;

@Configuration
public class MontadoraConfiguration {

    // Nesse Bean o professor deixou algo mais didatico, mas a definição poderia ser sem os setters e passandos as infos
    // diretamente na instancia do objeto, e também não precisa os valores serem Hardcoded (Foi apenas para entendimento do Bean)
    // Poderia ter mais de um Bean do tipo motor, e para melhorar a organização, eu posso usar a funçõa de name do Bean
    @Bean(name = "motor")
    public Motor motor(){
        var motor = new Motor();
        motor.setCavaloes(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }
}

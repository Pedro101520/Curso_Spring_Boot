package tech.pedrolima.arquiteturaspring.montadora;

import java.awt.*;

public class Carro {

    private String modelo;
    // É uma classe que vem junto do java.awt
    private Color cor;
    private Motor motor;
    private Montadora montadora;

    // Aqui foi apenas uma escolha do professor, eu poderia ter passado todos os valores dessa classe no construtor, incluindo o Motor
    public Carro(Motor motor) {
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Montadora getMontadora() {
        return montadora;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }

    // Aqui eu faço uma verificação, onde se a chave do carro que for indicado, não for igual ao da montadora, eu indico as ações
    public CarroStatus darIgnicao(Chave chave) {
        if(chave.getMontadora() != this.montadora){
            // Aqui é a classe record, que basicamente serve para quando se tem poucos dados, e como recebe apenas um texto, serve para esse proposito
            return new CarroStatus("Não é possivel ligar o carro pois a montadora da chave indicada não é igual a do carro");
        }else {
            return new CarroStatus("Carro ligado, com o motor: " + motor);
        }
    }
}

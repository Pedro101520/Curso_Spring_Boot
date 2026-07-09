package tech.pedrolima.arquiteturaspring.montadora;

// Esse record serve paenas para a crição de classes simples

// Classes do tipo record retornam isso de forma automatica:

//Construtor
//Getters (com outro nome)
//equals()
//hashCode()
//toString()

public record CarroStatus(String mensagem) {
}

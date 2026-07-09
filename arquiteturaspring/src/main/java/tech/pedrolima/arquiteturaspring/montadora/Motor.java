package tech.pedrolima.arquiteturaspring.montadora;

public class Motor {

    private String modelo;
    private Integer cavaloes;
    private Integer cilindros;
    private Double litragem;
    private TipoMotor tipo;


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCavaloes() {
        return cavaloes;
    }

    public void setCavaloes(Integer cavaloes) {
        this.cavaloes = cavaloes;
    }

    public Integer getCilindros() {
        return cilindros;
    }

    public void setCilindros(Integer cilindros) {
        this.cilindros = cilindros;
    }

    public Double getLitragem() {
        return litragem;
    }

    public void setLitragem(Double litragem) {
        this.litragem = litragem;
    }

    public TipoMotor getTipo() {
        return tipo;
    }

    public void setTipo(TipoMotor tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "modelo='" + modelo + '\'' +
                ", cavaloes=" + cavaloes +
                ", cilindros=" + cilindros +
                ", litragem=" + litragem +
                ", tipo=" + tipo +
                '}';
    }
}

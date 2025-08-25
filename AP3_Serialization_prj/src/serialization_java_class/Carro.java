package serialization_java_class;
import java.io.Serializable;

public class Carro implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String marca;
    private String modelo; 
    private String anoModelo;
    private String placa;

    public Carro (String marca, String modelo, String anoModelo, String placa){
        super();
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.placa = placa;
    }

    @Override
    public String toString() {
        return "Carro [marca=" + marca + ", modelo=" + modelo + ", anoModelo=" + anoModelo + ", placa=" + placa + "]";
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }    
}

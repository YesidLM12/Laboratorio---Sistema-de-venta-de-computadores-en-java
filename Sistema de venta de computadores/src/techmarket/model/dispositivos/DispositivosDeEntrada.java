package techmarket.model.dispositivos;

import techmarket.utils.IdGenerator;

public class DispositivosDeEntrada {
  private int idDispositivoEntrada;
  private String tipo;
  private String marca;
  private double precio;
  
  public DispositivosDeEntrada(String tipo, String marca) {
    idDispositivoEntrada = IdGenerator.nextId();
    this.tipo = tipo;
    this.marca = marca;
  }
  
  public String getTipo() {
    return tipo;
  }
  
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  public String getMarca() {
    return marca;
  }
  
  public void setMarca(String marca) {
    this.marca = marca;
  }
  
  @Override
  public String toString() {
    return "id: " + idDispositivoEntrada + " tipo: " + tipo + ", marca: " + marca;
  }
  
  public double getPrecio() {
    return precio;
  }
}



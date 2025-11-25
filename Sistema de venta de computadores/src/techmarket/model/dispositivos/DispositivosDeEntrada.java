package techmarket.model.dispositivos;


public class DispositivosDeEntrada {
  // Atributos
  private String tipo;
  private String marca;
  private double precio;
  
  // Constructor
  public DispositivosDeEntrada(String marca) {
    this.marca = marca;
  }
  
  // getter y setter
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
  
  public double getPrecio() {
    return precio;
  }
  
  @Override
  public String toString() {
    return "marca: " + marca;
  }
  
}



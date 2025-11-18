package techmarket.model.dispositivos;

import techmarket.utils.IdGenerator;

public class Teclado extends DispositivosDeEntrada{
  private int id;
  private String tipoTeclado;
  private double precio;
  
  public Teclado(String marca, String tipoTeclado, double precio) {
    id = IdGenerator.generarIdTeclado();
    super(marca);
    this.tipoTeclado = tipoTeclado;
    this.precio = precio;
  }
  
  public int getId() {
    return id;
  }
  
  public Teclado(String tipo, String marca) {
    super(marca);
  }
  
  public String getTipoTeclado() {
    return tipoTeclado;
  }
  
  @Override
  public double getPrecio() {
    return precio;
  }
  
  public void setPrecio(double precio) {
    this.precio = precio;
  }
  
  @Override
  public String toString() {
    return "id: " + getId() + " ," + super.toString() + ", Tipo de teclado: " + tipoTeclado + ", Precio: " + getPrecio();
  }
}

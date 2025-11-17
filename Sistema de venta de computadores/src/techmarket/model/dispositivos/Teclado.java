package techmarket.model.dispositivos;

import techmarket.utils.IdGenerator;

public class Teclado extends DispositivosDeEntrada{
  private int id;
  private String tipoTeclado;
  private double precio;
  
  public Teclado(String tipo, String marca, String tipoTeclado, double precio) {
    id = IdGenerator.generarIdTeclado();
    super(tipo, marca);
    this.tipoTeclado = tipoTeclado;
    this.precio = precio;
  }
  
  public Teclado(String tipo, String marca) {
    super(tipo, marca);
  }
  
  public String getTipoTeclado() {
    return tipoTeclado;
  }

  @Override
  public String toString() {
    return "Teclado: " + super.toString() + " Tipo de teclado: " + tipoTeclado + ".\n";
  }
}

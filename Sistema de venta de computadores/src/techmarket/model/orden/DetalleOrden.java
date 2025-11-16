package techmarket.model.orden;

import techmarket.model.computadora.Computadora;

public class DetalleOrden {
  private Computadora computadora;
  private int cantidad;
  
  public DetalleOrden(Computadora computadora, int cantidad) {
    this.computadora = computadora;
    this.cantidad = cantidad;
  }
  
  public double calcularSubtotal() {
    return computadora.getPrecio() * cantidad;
  }
}

package techmarket.model.cliente;

import techmarket.model.orden.Orden;
import techmarket.utils.IdGenerator;

import java.util.List;

public class Cliente {
  private final int idCliente;
  private String nombre;
  public static List<Orden> historialOrdenes;
  
  public Cliente(String nombre) {
    idCliente = IdGenerator.generarIdCliente();
    this.nombre = nombre;
  }
  
  public int getIdCliente() {
    return idCliente;
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public List<Orden> getHistorialOrdenes() {
    return historialOrdenes;
  }
  
  public static void agregarOrden(Orden orden) {
    historialOrdenes.add(orden);
  }
  
  @Override
  public String toString() {
    return "id: "+ getIdCliente() + ", " +"nombre: " + nombre + ", historialOrdenes: " + historialOrdenes;
  }
}

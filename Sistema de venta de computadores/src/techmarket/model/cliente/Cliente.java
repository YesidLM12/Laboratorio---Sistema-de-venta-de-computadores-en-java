package techmarket.model.cliente;

import techmarket.model.orden.Orden;
import techmarket.utils.IdClienteGenerator;
import techmarket.utils.IdGenerator;

import java.util.List;

public class Cliente {
  private int idCliente;
  private String nombre;
  public List<Orden> historialOrdenes;
  
  public Cliente(String nombre) {
    idCliente = IdClienteGenerator.nextId();
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
  
  public void agregarOrden(Orden orden) {
    this.historialOrdenes.add(orden);
  }
  
  @Override
  public String toString() {
    return "Cliente{" + "idCliente=" + idCliente + ", nombre='" + nombre + '\'' + ", historialOrdenes=" + historialOrdenes + '}';
  }
}

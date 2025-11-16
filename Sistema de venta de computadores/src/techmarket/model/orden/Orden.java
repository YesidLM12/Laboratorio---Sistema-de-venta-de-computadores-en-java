package techmarket.model.orden;

import techmarket.model.computadora.Computadora;
import techmarket.utils.IdGenerator;

import java.util.List;

public class Orden {
  private int idOrden;
  private Cliente cliente;
  private List<Computadora>  computadoras;
  
  public Orden(int idOrden, Cliente cliente, List<Computadora> computadoras) {
    idOrden = IdGenerator.nextId();
    this.idOrden = idOrden;
    this.cliente = cliente;
    this.computadoras = computadoras;
  }
  
  public int getIdOrden() {
    return idOrden;
  }
  
  public void agregarComputadora(Computadora computadora) {
    computadoras.add(computadora);
  }
  
  public Cliente getCliente() {
    return cliente;
  }
  
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
  
  public double calcularTotal() {
    double total = 0;
    for (Computadora computadora : computadoras) {
      total += computadora.getPrecio();
    }
    return total;
  }
  
  public void mostrarOrden() {
    System.out.println("Orden ID: " + idOrden);
    System.out.println("Cliente: " + cliente);
    System.out.println("Computadoras en la orden:");
    for (Computadora computadora : computadoras) {
      System.out.println(computadora);
    }
    System.out.println("Total de la orden: $" + calcularTotal());
  }
}

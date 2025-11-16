package techmarket.model.orden;

import techmarket.model.cliente.Cliente;
import techmarket.model.computadora.Computadora;
import techmarket.utils.IdOrderGenerator;

import java.util.List;

public class Orden {
  private int idOrden = IdOrderGenerator.nextId();
  private Cliente cliente;
  private List<Computadora>  computadoras = new java.util.ArrayList<>();
  
 
  
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

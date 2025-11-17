package techmarket.model.orden;

import techmarket.model.cliente.Cliente;
import techmarket.model.computadora.Computadora;

import java.time.LocalDateTime;
import java.util.List;

public class Orden {
  private final int idOrden = IdOrderGenerator.nextId();
  private Cliente cliente;
  private List<Computadora> computadoras = new java.util.ArrayList<>();
  private LocalDateTime fechaOrden;
  private EstadoOrden estado;
  

  public Orden(Cliente cliente) {
    this.cliente = cliente;
  }

  public int getIdOrden() {
    return idOrden;
  }
  
  public LocalDateTime getFechaOrden() {
    return fechaOrden;
  }
  
  public List<Computadora> getComputadoras() {
    return computadoras;
  }
  
  public void setFechaOrden(LocalDateTime now) {
    this.fechaOrden = now;
  }
  
  public EstadoOrden getEstado() {
    return estado;
  }
  
  public void setEstado(EstadoOrden estado) {
    this.estado = estado;
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
    System.out.println("Computadoras en la orden:\n");
    for (Computadora computadora : computadoras) {
      System.out.println(computadora);
    }
    System.out.println("Total de la orden: $" + calcularTotal());
  }
  
}

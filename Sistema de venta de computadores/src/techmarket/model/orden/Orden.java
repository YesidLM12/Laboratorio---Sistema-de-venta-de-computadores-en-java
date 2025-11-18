package techmarket.model.orden;

import techmarket.model.cliente.Cliente;
import techmarket.model.computadora.Computadora;
import techmarket.model.inventario.Inventario;
import techmarket.utils.IdGenerator;

import java.time.LocalDateTime;

import static techmarket.model.inventario.Inventario.computadoras;

public class Orden {
  private final int idOrden = IdGenerator.generarIdOrden();
  private Cliente cliente;
  private LocalDateTime fechaOrden;
  private EstadoOrden estado = EstadoOrden.PENDIENTE;
  

  public Orden(Cliente cliente) {
    this.cliente = cliente;
  }

  public int getIdOrden() {
    return idOrden;
  }
  
  public LocalDateTime getFechaOrden() {
    return fechaOrden;
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

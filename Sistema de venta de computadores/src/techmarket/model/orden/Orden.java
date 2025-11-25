package techmarket.model.orden;

import techmarket.model.cliente.Cliente;
import techmarket.model.computadora.Computadora;
import techmarket.utils.IdGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static techmarket.model.inventario.Inventario.computadoras;

public class Orden {
  private final int idOrden = IdGenerator.generarIdOrden();
  private Cliente cliente;
  private LocalDateTime fechaOrden;
  private EstadoOrden estado = EstadoOrden.PENDIENTE;
  public List<Computadora> ordenComputadoras = new ArrayList<>();
  

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
    ordenComputadoras.add(computadora);
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public static double calcularTotal() {
    double total = 0;
    for (Computadora computadora : computadoras) {
      total += computadora.getPrecio();
    }
    return total;
  }

  public String mostrarDetallesOrden() {
    return "Orden ID: " + idOrden + "\n" +
           "Cliente: " + cliente.getNombre() + "\n" +
           "Fecha: " + fechaOrden + "\n" +
           "Estado: " + estado + "\n" +
           "\nComputadoras en la orden:\n" +
           ordenComputadoras + "\n" +
           "Total de la orden: $" + calcularTotal();
  }
}

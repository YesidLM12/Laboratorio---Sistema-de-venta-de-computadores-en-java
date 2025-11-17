package techmarket.services;


import techmarket.model.cliente.Cliente;
import techmarket.model.computadora.Computadora;
import techmarket.model.orden.EstadoOrden;
import techmarket.model.orden.Orden;

import java.time.LocalDateTime;

public class OrdenService {
  
  // ===========================
  // crear orden
  // ===========================
  
  public Orden crearOrden(Cliente cliente) {
  
    // Validación básica
    if (cliente == null) {
      throw new IllegalArgumentException("El cliente no puede ser nulo");
    }
    
    // Crear orden con datos iniciales
    Orden orden = new Orden(cliente);
    
    orden.setEstado(EstadoOrden.valueOf("CREADA"));
    orden.setFechaOrden(LocalDateTime.now());
    
    // Registrar orden en ru "repositorio" o lista interna
    // TODO => implementar repositorio de órdenes
    
    return orden;
  }
  
  // ===========================
  // agregar computadora a orden
  // ===========================
  
  public void agregarComputadoraAOrden(Orden orden, Computadora computadora){
    // Validación básica
    if (orden == null) {
      throw new IllegalArgumentException("La orden no puede ser nula");
    }
    if (computadora == null) {
      throw new IllegalArgumentException("La computadora no puede ser nula");
    }
    
    // Validar que aún se puedan agregar productos
    if (!orden.getEstado().equals(EstadoOrden.CREADA)) {
      throw new IllegalStateException("No se pueden agregar productos a una orden que no está en estado CREADA");
    }
    
    // Validar stock de cada componente antes de agregarla
    if(!Inventarioservice.hayStockComputadores()){
      throw new IllegalStateException("No hay stock suficiente para los componentes de esta computadora");
    }
    
    // Agregar computadora a la orden
    orden.agregarComputadora(computadora);
    
    // Actualizar stock en inventario
    Inventarioservice.descontarStock(computadora);
  }
  
  // ===========================
  // Calcular total orden
  // ===========================
  
  public double calcularTotalOrden(Orden orden) {
    // Validación básica
    if (orden == null) {
      throw new IllegalArgumentException("La orden no puede ser nula");
    }
    
    double total = 0.0;
    
    // Sumar el precio de cada computadora en la orden
    for (Computadora computadora : orden.getComputadoras()) {
      total += computadora.getPrecio();
    }
    
    return total;
  }
  
  // ===========================
  // Mostrar detalles de la orden
  // ===========================
  
  public String mostrarDetallesOrden(Orden orden) {
    // Validación básica
    if (orden == null) {
      throw new IllegalArgumentException("La orden no puede ser nula");
    }
    
    StringBuilder detalles = new StringBuilder();
    
    detalles.append("Detalles de la Orden:\n");
    detalles.append("Cliente: ").append(orden.getCliente().getNombre()).append("\n");
    detalles.append("Fecha: ").append(orden.getFechaOrden()).append("\n");
    detalles.append("Estado: ").append(orden.getEstado()).append("\n");
    detalles.append("Computadoras en la Orden:\n");
    
    for (Computadora computadora : orden.getComputadoras()) {
      detalles.append("- ").append(computadora.getDescripcion())
              .append(" | Precio: $").append(computadora.getPrecio()).append("\n");
    }
    
    detalles.append("Total: $").append(calcularTotalOrden(orden)).append("\n");
    
    return detalles.toString();
  }
}

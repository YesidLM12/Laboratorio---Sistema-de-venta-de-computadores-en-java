package techmarket.services;


import techmarket.model.cliente.Cliente;
import techmarket.model.computadora.Computadora;
import techmarket.model.orden.EstadoOrden;
import techmarket.model.orden.Orden;
import techmarket.utils.InputReader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdenService {
  
  static List<Orden> ordenes = new ArrayList<>();
  
  public static List<Orden> getOrdenes() {
    return ordenes;
  }
  
  public static void setOrdenes(List<Orden> ordenes) {
    OrdenService.ordenes = ordenes;
  }
  
  // ========================
  // Obtener orden por id
  // ========================
  
  public static Orden getOrdenPorId(int idOrden){
    
    for (Orden orden : ordenes){
      if (orden.getIdOrden() == idOrden){
        return orden;
      }
    }
   return  null;
  }
  
  // ========================
  // Registrar orden
  // =========================
  
  
  private void registrarOrden(Orden orden){
    ordenes.add(orden);
  }
  
  // ===========================
  // crear orden
  // ===========================
  
  
  // Cliente nuevo
  public void crearOrdenClienteNuevo() {
    
    String nombreCliente = InputReader.readString("Ingrese el nombre del cliente: ");
    Cliente cliente = new Cliente(nombreCliente);
    
    // Crear orden con datos iniciales
    Orden orden = new Orden(cliente);
    
    // Registrar computadoras en la orden
    int cantidadComputadoras = InputReader.readInt("¿Cuántas computadoras desea agregar a la orden? ");
    
    do {
      
      int idComputadora = InputReader.readInt("Ingrese el ID de la computadora a agregar a la orden: ");
      Computadora computadora = ComputadoraService.getComputadoraPorId(idComputadora);
      
      agregarComputadoraAOrden(orden, computadora);
      cantidadComputadoras--;
      
    } while (cantidadComputadoras > 0);
    
    orden.setEstado(EstadoOrden.CREADA);
    orden.setFechaOrden(LocalDateTime.now());
    Cliente.agregarOrden(orden);
    
    registrarOrden(orden);
    
    calcularTotalOrden(orden);
    
    mostrarDetallesOrden(orden.getIdOrden());
  }
  
  // Cliente existente
  public void crearOrdenClienteExistente() {
    
    String nombreCliente = InputReader.readString("Ingrese el nombre del cliente existente: ");
    Cliente cliente = ClienteService.getClientePorNombre(nombreCliente);
    
    if (cliente == null) {
      System.out.println("Cliente no encontrado. Por favor, cree una orden para un cliente nuevo.");
      return;
    }
    
    // crear orden con datos iniciales
    Orden orden = new Orden(cliente);
    
    // Registrar computadoras en la orden
    int cantidadComputadoras = InputReader.readInt("¿Cuántas computadoras desea agregar a la orden? ");
    
    while (cantidadComputadoras > 0) {
      int idComputadora = InputReader.readInt("Ingrese el ID de la computadora a agregar a la orden: ");
      Computadora computadora = ComputadoraService.getComputadoraPorId(idComputadora);
      
      agregarComputadoraAOrden(orden, computadora);
      
      System.out.println("Computadora agregada a la orden: " + computadora);
      cantidadComputadoras--;
    }
    
    orden.setEstado(EstadoOrden.CREADA);
    orden.setFechaOrden(LocalDateTime.now());
    
    registrarOrden(orden);
    
    calcularTotalOrden(orden);
    
    mostrarDetallesOrden(orden.getIdOrden());
  }
  
  
  
  // ===========================
  // agregar computadora a orden
  // ===========================
  
  private void agregarComputadoraAOrden(Orden orden, Computadora computadora){
    // Validación básica
    if (orden == null) {
      throw new IllegalArgumentException("La orden no puede ser nula");
    }
    if (computadora == null) {
      System.out.println("La computadora no puede ser nula");
      return;
    }
    
    // Validar que aún se puedan agregar productos
    if (orden.getEstado() == null) {
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
  
  private static double calcularTotalOrden(Orden orden) {
    // Validación básica
    if (orden == null) {
      throw new IllegalArgumentException("La orden no puede ser nula");
    }
    
    double total = 0.0;
    
    // Sumar el precio de cada computadora en la orden
    for (Computadora computadora : orden.ordenComputadoras) {
      total += computadora.getPrecio();
    }
    
    return total;
  }
  
  // ===========================
  // Mostrar detalles de la orden
  // ===========================
  
  public static String mostrarDetallesOrden(int idOrden) {
    Orden orden = getOrdenPorId(idOrden);
    
    if (orden == null){
      return null;
    }
    
    System.out.println("\nOrden ID: " + orden.getIdOrden());
    System.out.println("Cliente: " + orden.getCliente().getNombre());
    System.out.println("Fecha: " + orden.getFechaOrden());
    System.out.println("Estado: " + orden.getEstado());
    System.out.println("\nComputadoras en la orden:\n");
    for (Computadora computadora : orden.ordenComputadoras) {
      System.out.println(computadora);
    }
    System.out.println("Total de la orden: $" + calcularTotalOrden(orden));
    return null;
  }
  
  
  // ======================
  // Busca orden por ID
  // ======================
  
  public static void buscarOrdenPorId() {
    int idOrden = InputReader.readInt("Ingrese el ID de la orden a buscar: ");
    
    for (Orden orden : ordenes) {
      if (orden.getIdOrden() == idOrden) {
        System.out.println("Orden encontrada: \n " + orden.mostrarDetallesOrden());
        return;
      }
    }
  }
}

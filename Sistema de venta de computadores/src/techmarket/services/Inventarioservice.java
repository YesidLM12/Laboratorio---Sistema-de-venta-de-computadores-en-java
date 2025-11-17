package techmarket.services;

import techmarket.model.computadora.Computadora;
import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;


import static techmarket.model.inventario.Inventario.*;

public class Inventarioservice {
  
  // ===========================================
  // Agregar stock
  // ===========================================
  
  public void agregarStockMonitor(Monitor m){
    monitores.add(m);
    System.out.println("Monitor agregado al inventario.");
  }
  
  public void agregarStockTeclado(Teclado t){
    teclados.add(t);
    System.out.println("Teclado agregado al inventario.");
  }
  
  public void agregarStockMouse(Mouse mouse) {
    mouses.add(mouse);
    System.out.println("Mouse agregado al inventario.");
  }
  
  // ===========================================
  // Disponibilidad de stock
  // ===========================================
  
  // Para computadoras genéricas
  public boolean hayStockComputadores(int cantidad){
    return monitores.size() >= cantidad &&
           teclados.size() >= cantidad &&
           mouses.size() >= cantidad;
  }
  
  public static boolean hayStockComputadores(){
    return !monitores.isEmpty() &&
           !teclados.isEmpty() &&
           !mouses.isEmpty();
  }
  
  // Para computadoras con marcas específicas
  public boolean hayStockComputadores(String marcaMonitor, String marcaTeclado, String marcaMouse, int cantidad){
    long cantidadMonitores = monitores.stream()
            .filter(monitor -> monitor.getMarca().equalsIgnoreCase(marcaMonitor))
            .count();
    
    long cantidadTeclados = teclados.stream()
            .filter(teclado -> teclado.getMarca().equalsIgnoreCase(marcaTeclado))
            .count();
    
    long cantidadMouses = mouses.stream()
            .filter(mouse -> mouse.getMarca().equalsIgnoreCase(marcaMouse))
            .count();
    
    return cantidadMonitores >= cantidad &&
            cantidadTeclados >= cantidad &&
            cantidadMouses >= cantidad;
  }
  
  // =========================================================
  // Verificar si exsite stock de cada pieza
  // =========================================================
  
  public Monitor obtenerMonitorDisponible(String marca){
    for (Monitor monitor : monitores) {
      if (monitor.getMarca().equalsIgnoreCase(marca)) {
        return monitor;
      }
    }
    return null;
  }
  
  public Teclado obtenerTecladoDisponible(String marca){
    for (Teclado teclado : teclados) {
      if (teclado.getMarca().equalsIgnoreCase(marca)) {
        return teclado;
      }
    }
    return null;
  }
  
  public Mouse obtenerMouseDisponible(String marca){
    for (Mouse mouse : mouses) {
      if (mouse.getMarca().equalsIgnoreCase(marca)) {
        return mouse;
      }
    }
    return null;
  }
  
  // ==========================================================
  // Descontar Stock
  // ==========================================================
  
  // Para computadoras genéricas
  public static void descontarStock(Computadora c){
    monitores.remove(c.getMonitor());
    teclados.remove(c.getTeclado());
    mouses.remove(c.getMouse());
    System.out.println("Stock descontado correctamente.");
  }
  
  
  public static boolean descontarStock(Monitor monitor, Teclado teclado, Mouse mouse){
    
    boolean okMonitor = monitores.remove(monitor);
    boolean okTeclado = teclados.remove(teclado);
    boolean okMouse = mouses.remove(mouse);
    
    if (!okMonitor || !okTeclado || !okMouse) {
      System.out.println("Advertencia: uno o más dispositivos no estaban en el inventario.");
      return false;
    }
    System.out.println("Stock descontado correctamente.");
    return true;
  }
  
  // =========================================================
  // Método para mostrar el inventario completo
  // =========================================================
  
  public void mostrarInventario(){
    System.out.println("----- Inventario de Teclados -----");
    for (Teclado teclado : teclados) {
      System.out.println(teclado);
    }
    
    System.out.println("----- Inventario de Mouses -----");
    for (Mouse mouse : mouses) {
      System.out.println(mouse);
    }
    
    System.out.println("----- Inventario de Monitores -----");
    for (Monitor monitor : monitores) {
      System.out.println(monitor);
    }
  }
}


package techmarket.model.inventario;

import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
  public static Object Inventario;
  List<Teclado> teclados = new ArrayList<>();
  List<Mouse> mouses = new ArrayList<>();
  List<Monitor> monitores = new ArrayList<>();
  
  // =========================================================
  // Métodos para agregar dispositivos al inventario
  // =========================================================
  
  public void agregarTeclado(Teclado teclado){
    teclados.add(teclado);
    System.out.println("Teclado agregado al inventario.");
  }
  
  public void agregarMouse(Mouse mouse){
    mouses.add(mouse);
    System.out.println("Mouse agregado al inventario.");
  }
  
  public void agregarMonitor(Monitor monitor){
    monitores.add(monitor);
    System.out.println("Monitor agregado al inventario.");
  }
  
  public List<Teclado> getTeclados() {
    return teclados;
  }
  
  public List<Mouse> getMouses() {
    return mouses;
  }
  
  public List<Monitor> getMonitores() {
    return monitores;
  }
  
  // =========================================================
  // Métodos para verificar el stock de computadoras
  // =========================================================
  
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
  
  public boolean descontarStock(Monitor monitor, Teclado teclado, Mouse mouse){
    
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

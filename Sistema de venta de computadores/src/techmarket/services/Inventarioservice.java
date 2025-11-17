package techmarket.services;

import techmarket.model.computadora.Computadora;
import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;
import techmarket.utils.InputReader;


import static techmarket.model.inventario.Inventario.*;

public class Inventarioservice {
  
  // ===========================================
  // Agregar stock
  // ===========================================
  
  public void agregarStockMonitor(){
    String marca = InputReader.readString("Agrega la marca del monitor: ");
    double pulgadas = InputReader.readDouble("Agrega las pulgadas del monitor: ");
    double precio = InputReader.readDouble("Agrega el precio del monitor: ");
    
    Monitor m = new Monitor(marca,pulgadas, precio );
    monitores.add(m);
    System.out.println("Monitor agregado al inventario.");
  }
  
  public void agregarStockTeclado() {
    String marca = InputReader.readString("Agrega la marca del teclado: ");
    String tipoTeclado = InputReader.readString("Agrega el tipo de teclado: ");
    double precio = InputReader.readDouble("Agrega el precio del teclado: ");
    
    Teclado t = new Teclado(marca, tipoTeclado,precio);
    teclados.add(t);
    System.out.println("Teclado agregado al inventario.");
  }
  
  public void agregarStockMouse() {
    String marca = InputReader.readString("Agrega la marca del mouse: ");
    int cantidadDeBotones = InputReader.readInt("Agrega la cantidad de botones del mouse: ");
    double precio = InputReader.readDouble("Agrega el precio del mouse: ");
    
    Mouse mouse = new Mouse(marca,cantidadDeBotones, precio);
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
  public static boolean hayStockComputadores(String marcaMonitor, String marcaTeclado, String marcaMouse, int cantidad){
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
  // Eliminar stock por ID
  // =========================================================
  
  public static void eliminarTeclado(){
    int idTeclado = InputReader.readInt("Ingrese el ID del teclado a eliminar: ");
    Teclado tecladoAEliminar = null;
    
    for (Teclado teclado : teclados) {
      if (teclado.getId() == idTeclado) {
        tecladoAEliminar = teclado;
        break;
      }
    }
    
    if (tecladoAEliminar != null) {
      teclados.remove(tecladoAEliminar);
      System.out.println("Teclado eliminado del inventario.");
    } else {
      System.out.println("No se encontró un teclado con el ID proporcionado.");
    }
  }
  
  public static void eliminarMouse(){
    int idMouse = InputReader.readInt("Ingrese el ID del mouse a eliminar: ");
    Mouse mouseAEliminar = null;
    
    for (Mouse mouse : mouses) {
      if (mouse.getIdMouse() == idMouse) {
        mouseAEliminar = mouse;
        break;
      }
    }
    
    if (mouseAEliminar != null) {
      mouses.remove(mouseAEliminar);
      System.out.println("Mouse eliminado del inventario.");
    } else {
      System.out.println("No se encontró un mouse con el ID proporcionado.");
    }
  }
  
  
  public static void eliminarMonitor(){
    int idMonitor = InputReader.readInt("Ingrese el ID del monitor a eliminar: ");
    Monitor monitorAEliminar = null;
    
    for (Monitor monitor : monitores) {
      if (monitor.getIdMonitor() == idMonitor) {
        monitorAEliminar = monitor;
        break;
      }
    }
    
    if (monitorAEliminar != null) {
      monitores.remove(monitorAEliminar);
      System.out.println("Monitor eliminado del inventario.");
    } else {
      System.out.println("No se encontró un monitor con el ID proporcionado.");
    }
  }
  
  // =========================================================
  // Método para mostrar el inventario completo
  // =========================================================
  
  public static void mostrarInventario(){
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


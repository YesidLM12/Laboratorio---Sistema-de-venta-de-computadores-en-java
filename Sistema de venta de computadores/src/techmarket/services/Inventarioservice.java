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
  
  // Agregar Monitor
  public void agregarStockMonitor(){
    String marca = InputReader.readString("Agrega la marca del monitor: ");
    double pulgadas = InputReader.readDouble("Agrega las pulgadas del monitor: ");
    double precio = InputReader.readDouble("Agrega el precio del monitor: ");
    
    Monitor m = new Monitor(marca,pulgadas, precio );
    monitores.add(m);
    System.out.println("Monitor agregado al inventario.");
  }
  
  
  // Agregar Teclado
  public void agregarStockTeclado() {
    String marca = InputReader.readString("Agrega la marca del teclado: ");
    String tipoTeclado = InputReader.readString("Agrega el tipo de teclado: ");
    double precio = InputReader.readDouble("Agrega el precio del teclado: ");
    
    Teclado t = new Teclado(marca, tipoTeclado,precio);
    teclados.add(t);
    System.out.println("Teclado agregado al inventario.");
  }
  
  
  // Agregar mouse
  public void agregarStockMouse() {
    String marca = InputReader.readString("Agrega la marca del mouse: ");
    int cantidadDeBotones = InputReader.readInt("Agrega la cantidad de botones del mouse: ");
    double precio = InputReader.readDouble("Agrega el precio del mouse: ");
    
    Mouse mouse = new Mouse(marca,cantidadDeBotones, precio);
    mouses.add(mouse);
    System.out.println("Mouse agregado al inventario.");
  }
  
  
  // Agregar Computadora
  public void agregarStockComputadora(){
    Teclado t = null;
    Monitor m = null;
    Mouse mou = null;
    
    int idMonitor = InputReader.readInt("Ingresa el id del monitor que te interesa para esta computadora: ");
    for(Monitor monitor : monitores) {
      if (monitor.getIdMonitor() == idMonitor) {
        m = monitor;
        break;
      }
    }
    
    int idTeclado = InputReader.readInt("Ingresa el id del teclado que te interesa para este monitor: ");
    for ( Teclado teclado : teclados){
      if ( teclado.getId() == idTeclado) {
        t = teclado;
      }
    }
    
    
    int idMouse = InputReader.readInt("Ingresa el id del mouse que te interesa para este monitor: ");
    for ( Mouse mouse : mouses){
      if ( mouse.getIdMouse() == idMouse){
        mou = mouse;
      }
    }
    
    double precio = InputReader.readDouble("Ingrese el precio de la computadora: ");
    
    Computadora c = new Computadora(m,t,mou,precio);
    computadoras.add(c);
    System.out.println("Computadora agregada al inventario.");
  }
  
  
  
  // ===========================================
  // Disponibilidad de stock
  // ===========================================
  
  // Para computadoras genéricas
  public static boolean hayStockComputadores(){
    int cantidad = InputReader.readInt("Ingresa la cantidad de computadoras a consultar: ");
    return computadoras.size() >= cantidad;
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
    
    return cantidadMonitores < cantidad || cantidadTeclados < cantidad || cantidadMouses < cantidad;
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
  // Buscar por ID
  // =========================================================
  
  // Buscar computadora
  public static  Computadora obtenerComputadoraPorId(int idComputadora){
    for (Computadora computadora : computadoras ) {
      if (computadora.getIdComputadora() == idComputadora) {
        return computadora;
      }
    }
    return null;
  }
  
  
  // Buscar teclado
  public static void buscarTecladoPorId(){
    int idTeclado = InputReader.readInt("Ingrese el id del teclado a buscar: ");
    
    for (Teclado t : teclados){
      if(t.getId() == idTeclado){
        System.out.println("Teclado encontrado: " + t);
      } else {
        System.out.println("Teclado no encontrado.");
      }
    }
  }
  
  
  // Buscar mouse
  public static void buscarMousePorId(){
    int idMouse = InputReader.readInt("Ingrese el id del teclado a buscar:");
    
    for (Mouse m : mouses){
      if (m.getIdMouse() == idMouse){
        System.out.println("Mouse encontrado: " + m);
      } else {
        System.out.println("Mouse no encontrado.");
      }
    }
  }
  
  
  // Buscar monitor
  public static void buscarMonitorPorId(){
    int idMonitor = InputReader.readInt("Ingrese el id del monitor a buscar: ");
    
    for (Monitor m : monitores) {
      if ( m.getIdMonitor() == idMonitor) {
        System.out.println("Monitor encontrado: " + m);
      } else {
        System.out.println("Monitor no encontrado");
      }
    }
  }
  
  
  // ========================================================
  // Buscar por marca
  // ========================================================
  
  // buscar monitor
  public static  Monitor getMonitor(String marca){
    Monitor m = null;
    
    for (Monitor monitor : monitores){
      
      if (monitor.getMarca().equalsIgnoreCase(marca)){
        m = monitor;
        break;
      }
    }
    
    if (m == null){
      System.out.println("No hay monitor marca " + marca);
      return null;
    }
    return  m;
  }
  
  
  // buscar teclado
  public static Teclado getTeclado (String marca){
    Teclado t = null;
    
    for( Teclado teclado : teclados){
      
      if (teclado.getMarca().equalsIgnoreCase(marca)){
        t = teclado;
        break;
      }
    }
    
    if (t == null) {
      System.out.println("No hay teclado marca " + marca);
      return null;
    }
    
    return t;
  }
  
  
  // buscar mouse
  public static Mouse getMouse(String marca) {
    Mouse mouse = null;
    
    for (Mouse mou : mouses){
      if( mou.getMarca().equalsIgnoreCase("Genius") && mou.getCantidadBotones() == 2){
        mouse = mou;
        break;
      }
    }
    
    if (mouse == null){
      System.out.println("No hay Mouses marca Genius de 2 botones.");
      return null;
    }
    
    return mouse;
  }
  
  
  
  // =========================================================
  // Método para mostrar el inventario completo
  // =========================================================
  
  public static void mostrarInventario(){
    
    System.out.println("\n----- Inventario de Teclados -----");
    
    if (teclados.isEmpty()){
      System.out.println("\nNo hay articulos en el inventario");
    }
    
    for (Teclado teclado : teclados) {
      System.out.println(teclado);
    }
    
    
    System.out.println("\n----- Inventario de Mouses -----");
    
    if (mouses.isEmpty()){
      System.out.println("\nNo hay articulos en el inventario");
    }
    for (Mouse mouse : mouses) {
      System.out.println(mouse);
    }
    
    
    
    System.out.println("\n----- Inventario de Monitores -----");
    
    if (monitores.isEmpty()){
      System.out.println("\nNo hay articulos en el inventario");
    }
    
    for (Monitor monitor : monitores) {
      System.out.println(monitor);
    }
    
    
    System.out.println("\n----- Inventario de Computadoras -----");
    
    if (computadoras.isEmpty()) {
      System.out.println("\nNo hay articulos en el inventario");
    }
    
    for (Computadora c : computadoras) {
      System.out.println(c);
    }
  }
  
  
}


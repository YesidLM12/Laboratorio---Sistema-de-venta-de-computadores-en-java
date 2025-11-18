package techmarket.services;

import techmarket.model.computadora.Computadora;
import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;
import techmarket.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class ComputadoraService {
  
  static  List<Computadora> computadoras = new ArrayList<>();
  
  public List<Computadora> getComputadoras() {
    return computadoras;
  }
  
  public static void setComputadoras(List<Computadora> computadoras) {
    ComputadoraService.computadoras = computadoras;
  }
  
  // ==========================================
  // Crear computadoras
  // ==========================================
  
  public void crearComputadora(){
    
    // leer datos teclado
    String marcaTeclado = InputReader.readString("Ingrese la marca del teclado: ");
    String tipoTeclado = InputReader.readString("Ingrese el tipo de teclado (mecanico/membrana): ");
    double precioTeclado = InputReader.readDouble("Ingrese el precio del teclado: ");
    
    Teclado t = new Teclado(marcaTeclado,tipoTeclado,precioTeclado);
    
    
    // leer datos mouse
    String marcaMouse = InputReader.readString("Ingrese la marca del mouse: ");
    int cantidadBotones = InputReader.readInt("Ingrese la cantidad de botones del mouse: ");
    double precioMouse = InputReader.readDouble("Ingrese el precio del mouse: ");
    
    Mouse mouse = new Mouse(marcaMouse,cantidadBotones,precioMouse);
    
    
    // leer datos monitor
    String marcaMonitor = InputReader.readString("Ingrese la marca del monitor: ");
    double tamanio = InputReader.readDouble("Ingrese el tamaño del monitor (en pulgadas): ");
    double precioMonitor = InputReader.readDouble("Ingrese el precio del monitor: ");
    
    Monitor m = new Monitor(marcaMonitor,tamanio,precioMonitor);
    
    // validar stock real
    if (!Inventarioservice.hayStockComputadores(marcaMonitor, marcaTeclado, marcaMouse, 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return;
    }
    
    // crear computadora
    String nombre = InputReader.readString("Ingrese el nombre de la computadora: ");
    Computadora computadora = new Computadora(nombre, m, t, mouse);
    System.out.println("Computadora creada exitosamente: " + computadora);
  }
  
  
  
  public void crearComputadoraOfimatica(){
    
    // leer datos teclado
    String marcaTeclado = InputReader.readString("Ingrese la marca del teclado: ");
    String tipoTeclado = InputReader.readString("Ingrese el tipo de teclado (mecanico/membrana): ");
    double precioTeclado = InputReader.readDouble("Ingrese el precio del teclado: ");
    
    Teclado t = new Teclado(marcaTeclado,tipoTeclado,precioTeclado);
    
    
    // leer datos mouse
    String marcaMouse = InputReader.readString("Ingrese la marca del mouse: ");
    int cantidadBotones = InputReader.readInt("Ingrese la cantidad de botones del mouse: ");
    double precioMouse = InputReader.readDouble("Ingrese el precio del mouse: ");
    
    Mouse mouse = new Mouse(marcaMouse,cantidadBotones,precioMouse);
    
    
    // leer datos monitor
    String marcaMonitor = InputReader.readString("Ingrese la marca del monitor: ");
    double tamanio = InputReader.readDouble("Ingrese el tamaño del monitor (en pulgadas): ");
    double precioMonitor = InputReader.readDouble("Ingrese el precio del monitor: ");
    
    Monitor m = new Monitor(marcaMonitor,tamanio,precioMonitor);
    
    // validar stock real
    if (!Inventarioservice.hayStockComputadores(marcaMonitor, marcaTeclado, marcaMouse, 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return;
    }
    
    // crear computadora
    String nombre = InputReader.readString("Ingrese el nombre de la computadora: ");
    Computadora computadora = new Computadora(nombre, m, t, mouse);
    System.out.println("Computadora ofimática creada exitosamente: " + computadora);
  }
  
  
  
  public void crearComputadoraGamer(){
    
    // leer datos teclado
    String marcaTeclado = InputReader.readString("Ingrese la marca del teclado: ");
    String tipoTeclado = InputReader.readString("Ingrese el tipo de teclado (mecanico/membrana): ");
    double precioTeclado = InputReader.readDouble("Ingrese el precio del teclado: ");
    
    Teclado t = new Teclado(marcaTeclado,tipoTeclado,precioTeclado);
    
    
    // leer datos mouse
    String marcaMouse = InputReader.readString("Ingrese la marca del mouse: ");
    int cantidadBotones = InputReader.readInt("Ingrese la cantidad de botones del mouse: ");
    double precioMouse = InputReader.readDouble("Ingrese el precio del mouse: ");
    
    Mouse mouse = new Mouse(marcaMouse,cantidadBotones,precioMouse);
    
    
    // leer datos monitor
    String marcaMonitor = InputReader.readString("Ingrese la marca del monitor: ");
    double tamanio = InputReader.readDouble("Ingrese el tamaño del monitor (en pulgadas): ");
    double precioMonitor = InputReader.readDouble("Ingrese el precio del monitor: ");
    
    Monitor m = new Monitor(marcaMonitor,tamanio,precioMonitor);
    
    // validar stock real
    if (!Inventarioservice.hayStockComputadores(marcaMonitor, marcaTeclado, marcaMouse, 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return;
    }
    
    // crear computadora
    String nombre = InputReader.readString("Ingrese el nombre de la computadora: ");
    Computadora computadora = new Computadora(nombre, m, t, mouse);
    System.out.println("Computadora gamer creada exitosamente: " + computadora);
  }
  
  
  public void crearComputadoraEstudiante(){
    
    // leer datos teclado
    String marcaTeclado = InputReader.readString("Ingrese la marca del teclado: ");
    String tipoTeclado = InputReader.readString("Ingrese el tipo de teclado (mecanico/membrana): ");
    double precioTeclado = InputReader.readDouble("Ingrese el precio del teclado: ");
    
    Teclado t = new Teclado(marcaTeclado,tipoTeclado,precioTeclado);
    
    
    // leer datos mouse
    String marcaMouse = InputReader.readString("Ingrese la marca del mouse: ");
    int cantidadBotones = InputReader.readInt("Ingrese la cantidad de botones del mouse: ");
    double precioMouse = InputReader.readDouble("Ingrese el precio del mouse: ");
    
    Mouse mouse = new Mouse(marcaMouse,cantidadBotones,precioMouse);
    
    
    // leer datos monitor
    String marcaMonitor = InputReader.readString("Ingrese la marca del monitor: ");
    double tamanio = InputReader.readDouble("Ingrese el tamaño del monitor (en pulgadas): ");
    double precioMonitor = InputReader.readDouble("Ingrese el precio del monitor: ");
    
    Monitor m = new Monitor(marcaMonitor,tamanio,precioMonitor);
    
    // validar stock real
    if (!Inventarioservice.hayStockComputadores(marcaMonitor, marcaTeclado, marcaMouse, 1)) {
      System.out.println("No hay stock suficiente para crear la computadora para estudiante.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return;
    }
    
    // crear computadora
    String nombre = InputReader.readString("Ingrese el nombre de la computadora: ");
    Computadora computadora = new Computadora(nombre, m, t, mouse);
    System.out.println("Computadora para estudiante creada exitosamente: " + computadora);
  }
  
  // ==========================================
  // calcular precio final
  // ==========================================
  
  public double calcularPrecioFinal(List<Computadora> inventario){
    int idComputadora = InputReader.readInt("Ingrese el ID de la computadora para calcular su precio final: ");
    
    Computadora computadora = null;
    
    // Buscar la computadora por ID
    for (Computadora c : inventario) {
      if (c.getIdComputadora() == idComputadora) {
        computadora = c;
        break;
      }
    }
    
    if (computadora == null) {
      System.out.println("Computadora con ID " + idComputadora + " no encontrada.");
      return 0.0;
    }
    
    double precioTeclado = computadora.getTeclado().getPrecio();
    double precioMouse = computadora.getMouse().getPrecio();
    double precioMonitor = computadora.getMonitor().getPrecio();
    
    return precioMonitor + precioTeclado + precioMouse;
    
  }
  
  public static Computadora getComputadoraPorId(int idComputadora){
    
    // Buscar la computadora por ID
    Computadora computadora = Inventarioservice.obtenerComputadoraPorId(idComputadora);
    
    if (computadora == null) {
      System.out.println("Computadora con ID " + idComputadora + " no encontrada.");
    } else {
      System.out.println("Computadora encontrada: " + computadora);
    }
    return computadora;
  }
  
  
  public static void buscarComputadoraPorId(){
    int idComputadora = InputReader.readInt("Ingrese el id de la computadora a buscar");
    
    
    // Buscar la computadora por ID
    Computadora computadora = Inventarioservice.obtenerComputadoraPorId(idComputadora);
    
    if (computadora == null) {
      System.out.println("Computadora con ID " + idComputadora + " no encontrada.");
    } else {
      System.out.println("Computadora encontrada: " + computadora);
    }
  }
}

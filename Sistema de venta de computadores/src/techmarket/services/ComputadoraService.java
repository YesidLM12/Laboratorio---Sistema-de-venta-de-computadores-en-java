package techmarket.services;

import techmarket.model.computadora.Computadora;
import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;
import techmarket.utils.InputReader;
import techmarket.utils.Validador;

import static techmarket.model.inventario.Inventario.*;
import static techmarket.services.Inventarioservice.*;

public class ComputadoraService {
  
  // ==========================================
  // Crear computadoras
  // ==========================================
  
  // Computadora generica
  public void crearComputadoraCustoms(){
    
    String marcaMonitor = InputReader.readString("Ingrese la marca del monitor");
    String marcaTeclado = InputReader.readString("Ingrese la marca del teclado");
    String marcaMouse = InputReader.readString("Ingrese la marca del mouse");
    
    // Buscar monitor 
    Monitor monitor = getMonitor(marcaMonitor);
    
    // Buscar Teclado 
    Teclado teclado = getTeclado(marcaTeclado);
    
    // Buscar mouse 
    Mouse mouse = getMouse(marcaMouse);

    // validar stock real
    if(monitor == null || teclado == null || mouse == null){
      System.out.println("No se encontro el monitor, teclado o mouse.");
      return;
    }
   
    if (Inventarioservice.hayStockComputadores(monitor.getMarca(), teclado.getMarca(), mouse.getMarca(), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(monitor,teclado,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return;
    }
    
    // Asignar precio
    double precio = InputReader.readDouble("Ingrese el precio de la computadora: ");
    
    // Validar que el precio sea aceptable
    boolean valido = Validador.esPrecioValido(precio);
    
    if (!valido){
      System.out.println("El precio es inválido.");
      return;
    }
    
    // crear computadora
    Computadora computadora = new Computadora(monitor, teclado, mouse, precio);
    
    computadoras.add(computadora);
    double precioFinal = calcularPrecioFinal(computadora);
    computadora.setPrecio(precioFinal);
    
    System.out.println("Computadora creada exitosamente:\n" + computadora +"\nPrecio Final: $" + precioFinal);
  }
  
  
  // Computadora Ofimatica
  public void crearComputadoraOfimatica(){
    
    // Buscar monitor Samsung
    Monitor monitor = getMonitor("samsung");
    
    // Buscar Teclado Samsung
    Teclado teclado = getTeclado("samsung");
    
    
    // Buscar mouse Samsung
    Mouse mouse = getMouse("samsung");
    
    // validar stock real
     if(monitor == null || teclado == null || mouse == null){
      System.out.println("No se encontro el monitor, teclado o mouse.");
      return;
    }
    if (Inventarioservice.hayStockComputadores(String.valueOf(monitor),String.valueOf(teclado),String.valueOf(mouse), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(monitor,teclado,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return;
    }
    
    // Asignar precio
    double precio = InputReader.readDouble("Ingrese el precio de la computadora: ");
    
    // Validar que el precio sea aceptable
    boolean valido = Validador.esPrecioValido(precio);
    
    if (!valido){
      System.out.println("El precio es inválido.");
      return;
    }
    
    // crear computadora
    Computadora computadora = new Computadora(monitor, teclado, mouse, precio);
    computadoras.add(computadora);
    
    double precioFinal = calcularPrecioFinal(computadora);
    computadora.setPrecio(precioFinal);
    
    System.out.println("Computadora creada exitosamente:\n" + computadora +"\nPrecio Final: $" + precioFinal);
  }
  
  
  // Computadora Gamer
  public void crearComputadoraGamer(){
    
    // Buscar monitor Razer
    Monitor monitor = getMonitor("razer");
    
    // Buscar Teclado Razer
    Teclado teclado = getTeclado("razer");
    
    // Buscar mouse Razer
    Mouse mouse = getMouse("razer");
    
    // validar stock real
     if(monitor == null || teclado == null || mouse == null){
      System.out.println("No se encontro el monitor, teclado o mouse.");
      return;
    }
    
    if (Inventarioservice.hayStockComputadores(String.valueOf(monitor),String.valueOf(teclado),String.valueOf(mouse), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(monitor,teclado,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return;
    }
    
    // Asignar precio
    double precio = InputReader.readDouble("Ingrese el precio de la computadora: ");
    
    // Validar que el precio sea aceptable
    boolean valido = Validador.esPrecioValido(precio);
    
    if (!valido){
      System.out.println("El precio es inválido.");
      return;
    }
    
    // crear computadora
    Computadora computadora = new Computadora(monitor, teclado, mouse, precio);
    computadoras.add(computadora);
    
    double precioFinal = calcularPrecioFinal(computadora);
    computadora.setPrecio(precioFinal);
    
    System.out.println("Computadora creada exitosamente:\n" + computadora +"\nPrecio Final: $" + precioFinal);
  }
  
  
  // Computadora estudiantil
  public void crearComputadoraEstudiante(){
    
    // Buscar monitor LG
    Monitor monitor = getMonitor("LG");
    
    // Buscar Teclado LG
    Teclado teclado = getTeclado("LG");
    
    
    // Buscar mouse LG
   Mouse mouse = getMouse("LG");
    
    // validar stock real
    if (Inventarioservice.hayStockComputadores(String.valueOf(monitor),String.valueOf(teclado),String.valueOf(mouse), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(monitor,teclado,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return;
    }
    
    // Asignar precio
    double precio = InputReader.readDouble("Ingrese el precio de la computadora: ");
    
    // Validar que el precio sea aceptable
    boolean valido = Validador.esPrecioValido(precio);
    
    if (!valido){
      System.out.println("El precio es inválido.");
      return;
    }
    
    // crear computadora
    Computadora computadora = new Computadora(monitor, teclado, mouse, precio);
    computadoras.add(computadora);
    double precioFinal = calcularPrecioFinal(computadora);
    computadora.setPrecio(precioFinal);
    
    System.out.println("Computadora creada exitosamente:\n" + computadora +"\nPrecio Final: $" + precioFinal);
  }
  
  // ==========================================
  // calcular precio final
  // ==========================================
  
  public double calcularPrecioFinal(Computadora computadora){
    
    double precioTeclado = computadora.getTeclado().getPrecio();
    double precioMouse = computadora.getMouse().getPrecio();
    double precioMonitor = computadora.getMonitor().getPrecio();
    
    return computadora.getPrecio() + precioMonitor + precioTeclado + precioMouse;
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

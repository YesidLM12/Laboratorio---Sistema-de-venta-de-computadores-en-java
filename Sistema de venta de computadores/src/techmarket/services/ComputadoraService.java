package techmarket.services;

import techmarket.model.computadora.Computadora;
import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;
import techmarket.model.inventario.Inventario;

public class ComputadoraService {
  
  // ==========================================
  // Crear computadoras
  // ==========================================
  
  public Computadora crearComputadora(String nombre, Monitor m, Teclado t, Mouse mouse, Inventario inventario){
    
    // validar stock real
    if (!Inventarioservice.hayStockComputadores(m.getMarca(), t.getMarca(), mouse.getMarca(), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora gamer.");
      return null;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return null;
    }
    
    // crear computadora
    Computadora computadora = new Computadora(nombre, m, t, mouse);
    System.out.println("Computadora creada exitosamente: " + computadora);
    return computadora;
  }
  
  public Computadora crearComputadoraOfimatica(String nombre, Monitor m, Teclado t, Mouse mouse, Inventario inventario){
    
    // validar stock real
    if (!Inventarioservice.hayStockComputadores(m.getMarca(), t.getMarca(), mouse.getMarca(), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora ofimática.");
      return null;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return null;
    }
    
    // crear computadora
    Computadora computadora = new Computadora(nombre, m, t, mouse);
    System.out.println("Computadora ofimática creada exitosamente: " + computadora);
    return computadora;
  }
  
  
  public Computadora crearComputadoraGamer(String nombre, Monitor m, Teclado t, Mouse mouse, Inventario inventario){
    
    // validar stock real
    if (!Inventarioservice.hayStockComputadores(m.getMarca(), t.getMarca(), mouse.getMarca(), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora gamer.");
      return null;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return null;
    }
    
    // crear computadora
    Computadora computadora = new Computadora(nombre, m, t, mouse);
    System.out.println("Computadora gamer creada exitosamente: " + computadora);
    return computadora;
  }
  
  
  public Computadora crearComputadoraEstudiante(String nombre, Monitor m, Teclado t, Mouse mouse, Inventario inventario){
    
    // validar stock real
    if (!Inventarioservice.hayStockComputadores(m.getMarca(), t.getMarca(), mouse.getMarca(), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora para estudiante.");
      return null;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
    if (!descontado) {
      System.out.println("Error al descontar el stock del inventario.");
      return null;
    }
    
    // crear computadora
    Computadora computadora = new Computadora(nombre, m, t, mouse);
    System.out.println("Computadora para estudiante creada exitosamente: " + computadora);
    return computadora;
  }
  
  // ==========================================
  // calcular precio final
  // ==========================================
  
  public double calcularPrecioFinal(Computadora computadora){
    double precioMonitor = computadora.getMonitor().getPrecio();
    double precioTeclado = computadora.getTeclado().getPrecio();
    double precioMouse = computadora.getMouse().getPrecio();
    
    return precioMonitor + precioTeclado + precioMouse;
  }
}

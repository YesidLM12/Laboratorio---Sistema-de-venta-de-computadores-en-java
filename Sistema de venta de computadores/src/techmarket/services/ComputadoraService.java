package techmarket.services;

import techmarket.model.computadora.Computadora;
import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;
import techmarket.model.inventario.Inventario.*;
import techmarket.utils.InputReader;
import techmarket.utils.Validador;

import java.util.List;

import static techmarket.model.inventario.Inventario.*;

public class ComputadoraService {
  
  // ==========================================
  // Crear computadoras
  // ==========================================
  
  // Computadora generica
  public void crearComputadora(){
    Monitor m = null;
    Teclado t = null;
    Mouse mouse = null;
    
    // Buscar monitor Genius
    for (Monitor monitor : monitores){
      
      if (monitor.getMarca().equalsIgnoreCase("Genius") && monitor.getTamanio() == 24){
        m = monitor;
        break;
      }
    }
    
    if (m == null){
      System.out.println("No hay monitor marca Genius de 24 pulgadas disponible.");
      return;
    }
    
    
    // Buscar Teclado Genius
    for( Teclado teclado : teclados){
      
      if (teclado.getMarca().equalsIgnoreCase("Genius") && teclado.getTipoTeclado().equalsIgnoreCase("membrana")){
        t = teclado;
        break;
      }
    }
    
    if (t == null) {
      System.out.println("No hay teclado marca Genius de membrana.");
      return;
    }
    
    
    // Buscar mouse genius
    for (Mouse mou : mouses){
       if( mou.getMarca().equalsIgnoreCase("Genius") && mou.getCantidadBotones() == 2){
         mouse = mou;
         break;
       }
    }
    
    if (mouse == null){
      System.out.println("No hay Maus marca Genius de 2 botones.");
      return;
    }
    
    // validar stock real
    if (Inventarioservice.hayStockComputadores(m.getMarca(),t.getMarca(),mouse.getMarca(), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
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
    Computadora computadora = new Computadora(m, t, mouse, precio);
    
    computadoras.add(computadora);
    System.out.println("Computadora creada exitosamente: " + computadora);
  }
  
  
  // Computadora Ofimatica
  public void crearComputadoraOfimatica(){
    
    Monitor m = null;
    Teclado t = null;
    Mouse mouse = null;
    
    // Buscar monitor Samsung
    for (Monitor monitor : monitores){
      
      if (monitor.getMarca().equalsIgnoreCase("Samsung") && monitor.getTamanio() == 27){
        m = monitor;
        break;
      }
    }
    
    if (m == null){
      System.out.println("No hay monitor marca Samsung de 27 pulgadas disponible.");
      return;
    }
    
    
    // Buscar Teclado Samsung
    for( Teclado teclado : teclados){
      
      if (teclado.getMarca().equalsIgnoreCase("Samsung") && teclado.getTipoTeclado().equalsIgnoreCase("membrana")){
        t = teclado;
        break;
      }
    }
    
    if (t == null) {
      System.out.println("No hay teclado marca Samsung de membrana.");
      return;
    }
    
    
    // Buscar mouse Samsung
    for (Mouse mou : mouses){
      if( mou.getMarca().equalsIgnoreCase("Samsung") && mou.getCantidadBotones() == 2){
        mouse = mou;
        break;
      }
    }
    
    if (mouse == null){
      System.out.println("No hay Maus marca Samsung de 2 botones.");
      return;
    }
    
    // validar stock real
    if (Inventarioservice.hayStockComputadores(m.getMarca(),t.getMarca(),mouse.getMarca(), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
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
    Computadora computadora = new Computadora(m, t, mouse, precio);
    computadoras.add(computadora);
    
    System.out.println("Computadora creada exitosamente: " + computadora);
  }
  
  
  // Computadora Gamer
  public void crearComputadoraGamer(){
    
    Monitor m = null;
    Teclado t = null;
    Mouse mouse = null;
    
    // Buscar monitor Razer
    for (Monitor monitor : monitores){
      
      if (monitor.getMarca().equalsIgnoreCase( "Razer") && monitor.getTamanio() == 27){
        m = monitor;
        break;
      }
    }
    
    if (m == null){
      System.out.println("No hay monitor marca Razer de 27 pulgadas disponible.");
      return;
    }
    
    
    // Buscar Teclado Razer
    for( Teclado teclado : teclados){
      
      if (teclado.getMarca().equalsIgnoreCase( "Razer") && teclado.getTipoTeclado().equalsIgnoreCase("membrana")){
        t = teclado;
        break;
      }
    }
    
    if (t == null) {
      System.out.println("No hay teclado marca Razer de membrana.");
      return;
    }
    
    
    // Buscar mouse Razer
    for (Mouse mou : mouses){
      if( mou.getMarca().equalsIgnoreCase( "Razer") && mou.getCantidadBotones() == 2){
        mouse = mou;
        break;
      }
    }
    
    if (mouse == null){
      System.out.println("No hay Maus marca Razer de 2 botones.");
      return;
    }
    
    // validar stock real
    if (Inventarioservice.hayStockComputadores(m.getMarca(),t.getMarca(),mouse.getMarca(), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
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
    Computadora computadora = new Computadora(m, t, mouse, precio);
    computadoras.add(computadora);
    
    System.out.println("Computadora creada exitosamente: " + computadora);
  }
  
  
  // Computadora estudiantil
  public void crearComputadoraEstudiante(){
    
    Monitor m = null;
    Teclado t = null;
    Mouse mouse = null;
    
    // Buscar monitor LG
    for (Monitor monitor : monitores){
      
      if (monitor.getMarca().equalsIgnoreCase("LG") && monitor.getTamanio() == 27){
        m = monitor;
        break;
      }
    }
    
    if (m == null){
      System.out.println("No hay monitor marca LG de 27 pulgadas disponible.");
      return;
    }
    
    
    // Buscar Teclado LG
    for( Teclado teclado : teclados){
      
      if (teclado.getMarca().equalsIgnoreCase("LG") && teclado.getTipoTeclado().equalsIgnoreCase("membrana")){
        t = teclado;
        break;
      }
    }
    
    if (t == null) {
      System.out.println("No hay teclado marca LG de membrana.");
      return;
    }
    
    
    // Buscar mouse LG
    for (Mouse mou : mouses){
      if( mou.getMarca().equalsIgnoreCase("LG") && mou.getCantidadBotones() == 2){
        mouse = mou;
        break;
      }
    }
    
    if (mouse == null){
      System.out.println("No hay Maus marca LG de 2 botones.");
      return;
    }
    
    // validar stock real
    if (Inventarioservice.hayStockComputadores(m.getMarca(),t.getMarca(),mouse.getMarca(), 1)) {
      System.out.println("No hay stock suficiente para crear la computadora.");
      return;
    }
    
    // descontar del inventario
    boolean descontado = Inventarioservice.descontarStock(m,t,mouse);
    
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
    Computadora computadora = new Computadora(m, t, mouse, precio);
    computadoras.add(computadora);
    
    System.out.println("Computadora creada exitosamente: " + computadora);
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

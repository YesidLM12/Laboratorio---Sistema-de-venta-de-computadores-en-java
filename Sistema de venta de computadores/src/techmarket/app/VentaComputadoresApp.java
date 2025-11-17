package techmarket.app;

import techmarket.model.computadora.Computadora;
import techmarket.model.dispositivos.DispositivosDeEntrada;
import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;
import techmarket.model.orden.Orden;

public class VentaComputadoresApp {
  static void main() {
    // ==================================
    // Caso de uso 1: DispositivoEntrada
    // ==================================
    
    System.out.println("\n=== Caso de uso 1: DispositivoEntrada ===");
    DispositivosDeEntrada disp1 = new DispositivosDeEntrada("USB", "Logitech");
    DispositivosDeEntrada disp2 = new DispositivosDeEntrada("Teclado", "Logitech");
    System.out.println(disp1);
    System.out.println(disp2);
    
    
    // ==================================
    // Caso de uso 2: Mouse y Teclado
    // ==================================
    
    System.out.println("\n=== Caso de uso 2: Mouse y Teclado ===");
    Mouse mouse1 = new Mouse("Bluetooth", "Dell", 3, 10);
    Mouse mouse2 = new Mouse("USB", "HP", 5);
    Mouse mouse3 = new Mouse("Inalámbrico", "Acer", 2, 8);
    
    Teclado teclado1 = new Teclado("USB", "Logitech", "QWERTY", 4);
    Teclado teclado2 = new Teclado("Bluetooth", "Microsoft", "AZERTY", 6);
    
    System.out.println(mouse1);
    System.out.println(mouse2);
    System.out.println(mouse3);
    System.out.println(teclado1);
    System.out.println(teclado2);
    
    
    // ==================================
    // Caso de uso 3: Monitor
    // ==================================
    
    System.out.println("\n=== Caso de uso 3: Monitor ===");
    Monitor monitorHP = new Monitor("HP", 15.6, 120);
    Monitor monitorDell = new Monitor("Dell", 14.0, 90);
    System.out.println(monitorHP);
    System.out.println(monitorDell);
    
    
  // ===================================
  // Caso de uso 4: Computadora completa
  // ===================================
    System.out.println("\n=== Caso de uso 4: Computadora completa ===");
    Computadora pc1 = new Computadora("PC Gamer", monitorHP, teclado1, mouse1);
    Computadora pc2 = new Computadora("PC Oficina", monitorDell, teclado2, mouse2);
    Computadora pc3 = new Computadora("PC Edición", monitorHP, teclado1, mouse3);
    System.out.println(pc1);
    System.out.println(pc2);
    
    
    // =====================================
    // Caso de uso 5: Orden con computadoras
    // =====================================
    System.out.println("\n=== Caso de uso 5: Orden con computadoras ===");
    Orden orden1 = new Orden();
    
    // Agregar computadoras a la orden
    orden1.agregarComputadora(pc1);
    orden1.agregarComputadora(pc2);
    orden1.agregarComputadora(pc3);
    
    // Mostrar la orden completa
    orden1.mostrarOrden();
    
    
    // =====================================
    // Caso de uso 6: Orden vacía
    // =====================================
    System.out.println("\n=== Caso de uso 6: Orden vacía ===");
    Orden orden2 = new Orden();
    orden2.mostrarOrden();
    
    
  }
}

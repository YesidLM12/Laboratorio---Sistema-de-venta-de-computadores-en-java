package techmarket.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
  
  private static final AtomicInteger contadorComputadora = new AtomicInteger(0);
  private static final AtomicInteger contadorCliente = new AtomicInteger(0);
  private static final AtomicInteger contadorOrden = new AtomicInteger(0);
  private static final AtomicInteger contadorMonitor = new AtomicInteger(0);
  private static final AtomicInteger contadorTeclado = new AtomicInteger(0);
  private static final AtomicInteger contadorMouse = new AtomicInteger(0);
  
  public static int generarIdComputadora() {
    return contadorComputadora.incrementAndGet();
  }
  
  public static int generarIdCliente() {
    return contadorCliente.incrementAndGet();
  }
  
  public static int generarIdOrden() {
    return contadorOrden.incrementAndGet();
  }
  
  public static int generarIdMonitor() {
    return contadorMonitor.incrementAndGet();
  }
  
  public static int generarIdTeclado() {
    return contadorTeclado.incrementAndGet();
  }
  
  public static int generarIdMouse() {
    return contadorMouse.incrementAndGet();
  }
}

package techmarket.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
  private static final AtomicInteger counter = new AtomicInteger(0);
  
  public static int nextId(){
    return counter.incrementAndGet();
  }
  
  public static int generarIdComputadora() {
    return nextId();
  }
  
  public static int generarIdCliente() {
    return nextId();
  }
  
  public static int generarIdOrden() {
    return nextId();
  }
  
  public static int generarIdMonitor() {
    return nextId();
  }
  
  public static int generarIdTeclado() {
    return nextId();
  }
  
  public static  int generarIdMouse() {
    return nextId();
  }
  
}


package techmarket.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdClienteGenerator {
  private static final AtomicInteger clientCounter = new AtomicInteger(0);
  
  public static int nextId(){
    return clientCounter.incrementAndGet();
  }
}

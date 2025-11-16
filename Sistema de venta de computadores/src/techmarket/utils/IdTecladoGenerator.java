package techmarket.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdTecladoGenerator {
  private static final AtomicInteger tecladoCounter = new AtomicInteger(0);
  
  public static int nextId(){
    return tecladoCounter.incrementAndGet();
  }
}

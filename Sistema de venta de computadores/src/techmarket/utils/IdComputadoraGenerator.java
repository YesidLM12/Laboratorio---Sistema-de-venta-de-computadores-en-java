package techmarket.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdComputadoraGenerator {
  private static final AtomicInteger computadoraCounter = new AtomicInteger(0);
  
  public static int nextId(){
    return computadoraCounter.incrementAndGet();
  }
}

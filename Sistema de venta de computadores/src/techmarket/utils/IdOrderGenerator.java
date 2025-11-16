package techmarket.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdOrderGenerator {
  private static final AtomicInteger orderCounter = new AtomicInteger(0);
  
  public static int nextId(){
    return orderCounter.incrementAndGet();
  }
}

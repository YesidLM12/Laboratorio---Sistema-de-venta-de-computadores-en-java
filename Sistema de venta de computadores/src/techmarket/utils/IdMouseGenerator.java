package techmarket.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdMouseGenerator {
  private static final AtomicInteger mouseCounter = new AtomicInteger(0);
  
  public static int nextId(){
    return mouseCounter.incrementAndGet();
  }
}

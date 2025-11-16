package techmarket.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class IdMonitorGenerator {
  private static final AtomicInteger monitorCounter = new AtomicInteger(0);
  
  public static int nextId(){
    return monitorCounter.incrementAndGet();
  }
}

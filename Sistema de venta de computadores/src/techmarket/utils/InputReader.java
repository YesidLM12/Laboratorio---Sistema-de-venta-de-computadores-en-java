package techmarket.utils;

import java.util.Scanner;

public class InputReader {
  public static final Scanner sc = new Scanner(System.in);
  
  public static String readString(String prompt) {
    System.out.print(prompt);
    return sc.nextLine();
  }
  
  public static int readInt(String prompt) {
    System.out.print(prompt);
    while (!sc.hasNextInt()) {
      sc.next(); // descarta lo inválido
      System.out.print("Entrada inválida. " + prompt);
    }
    int value = sc.nextInt();
    sc.nextLine(); // Limpiar el buffer
    return value;
  }
  
  public  static double readDouble(String prompt) {
    System.out.print(prompt);
    while (!sc.hasNextDouble()) {
      sc.next();
      System.out.print("Entrada inválida. " + prompt);
    }
    double value = sc.nextDouble();
    sc.nextLine(); // Limpiar el buffer
    return value;
  }
}

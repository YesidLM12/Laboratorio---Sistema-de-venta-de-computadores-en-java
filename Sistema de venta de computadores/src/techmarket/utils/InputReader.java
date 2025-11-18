package techmarket.utils;

import java.util.Scanner;

public class InputReader {
  /* Clase para optimizar el uso de Scanner.*/
  
  // creación de instancia
  public static final Scanner sc = new Scanner(System.in);
  
  // metodo para leer strings
  public static String readString(String prompt) {
    System.out.print(prompt);
    return sc.nextLine();
  }
  
  
  // metodo para leer int
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
  
  
  // metodo para leer double
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

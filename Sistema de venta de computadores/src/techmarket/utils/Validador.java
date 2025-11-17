package techmarket.utils;

public class Validador {
  public static boolean esTextoValido(String texto) {
    return texto != null && !texto.trim().isEmpty();
  }
  
  public static boolean esPrecioValido(double precio) {
    return precio >= 0;
  }
  
  public static boolean noEsVacio(String texto) {
    return texto != null && !texto.trim().isEmpty();
  }
}

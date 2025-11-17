package techmarket.model.inventario;

import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
  public static List<Teclado> teclados = new ArrayList<>();
  public static List<Mouse> mouses = new ArrayList<>();
  public static List<Monitor> monitores = new ArrayList<>();
  
  public List<Teclado> getTeclados() {
    return teclados;
  }
  
  public List<Mouse> getMouses() {
    return mouses;
  }
  
  public List<Monitor> getMonitores() {
    return monitores;
  }
}

package techmarket.model.computadora;

import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;
import techmarket.utils.IdGenerator;

import java.util.List;


public class Computadora{
  private final int idComputadora;
  private final String nombreComputadora;
  private double precio;
  private final Monitor monitor;
  private final Teclado teclado;
  private final Mouse mouse;
  private String descripcion;
  private static final List<Computadora> computadoras = new java.util.ArrayList<>();
  
  public Computadora(String nombreComputadora, Monitor monitor, Teclado teclado, Mouse mouse) {
    this.idComputadora = IdGenerator.generarIdComputadora();
    this.nombreComputadora = nombreComputadora;
    this.monitor = monitor;
    this.teclado = teclado;
    this.mouse = mouse;
  }
  
  public int getIdComputadora() {
    return idComputadora;
  }
  
  public String getNombreComputadora() {
    return nombreComputadora;
  }
  
  public Monitor getMonitor() {
    return monitor;
  }
  
  public Teclado getTeclado() {
    return teclado;
  }
  
  public Mouse getMouse() {
    return mouse;
  }
  
  public double getPrecio() {
    return precio;
  }
  
  public String getDescripcion() {
    return descripcion;
  }
  
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  
  
  public static List<Computadora> getComputadoras() {
    return computadoras;
  }
  
  
  
  public void agregarComputadora(Computadora computadora) {
    computadoras.add(computadora);
  }
  
  @Override
  public String toString() {
    return "Computadora{" + "idComputadora=" + idComputadora + ", nombreComputadora='" + nombreComputadora + '\'' + ", monitor=" + monitor + ", teclado=" + teclado + ", mouse=" + mouse + '}';
  }
}
package techmarket.model.computadora;

import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;
import techmarket.utils.IdGenerator;

import java.util.List;


public class Computadora{
  
  private final int idComputadora;
  private double precio;
  private final Monitor monitor;
  private final Teclado teclado;
  private final Mouse mouse;
  private String descripcion;
  private static final List<Computadora> computadoras = new java.util.ArrayList<>();
  
  public Computadora(Monitor monitor, Teclado teclado, Mouse mouse, double precio) {
    this.idComputadora = IdGenerator.generarIdComputadora();
    this.monitor = monitor;
    this.teclado = teclado;
    this.mouse = mouse;
    this.precio = precio;
  }
  
  public int getIdComputadora() {
    return idComputadora;
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
  
  public void setPrecio(double precio) {
    this.precio = precio;
  }
  
  public String getDescripcion() {
    return descripcion;
  }
  
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  @Override
  public String toString() {
    return "Computadora:\n" + "id: " + idComputadora  + "\nmonitor: " + monitor + "\nteclado: " + teclado + "\nmouse: " + mouse + '\n';
  }
  
  
}
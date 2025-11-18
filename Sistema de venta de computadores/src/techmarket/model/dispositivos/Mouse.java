package techmarket.model.dispositivos;

import techmarket.utils.IdGenerator;

public class Mouse extends DispositivosDeEntrada {
  private int id;
  private int cantidadBotones;
  private double precio;
  
  public Mouse(String marca, int cantidadBotones, double precio) {
    id = IdGenerator.generarIdMouse();
    super(marca);
    this.cantidadBotones = cantidadBotones;
    this.precio = precio;
  }

  public int getIdMouse(){
    return id;
  }
  
  public int getCantidadBotones() {
    return cantidadBotones;
  }
  
  public void setCantidadBotones(int cantidadBotones) {
    this.cantidadBotones = cantidadBotones;
  }
  
  @Override
  public double getPrecio() {
    return precio;
  }
  
  public void setPrecio(double precio) {
    this.precio = precio;
  }
  
  @Override
  public String toString() {
    return "id: " + getIdMouse() + " " + super.toString() + ", Cantidad de botones:" + cantidadBotones + ", Precio: " + getPrecio();
  }
}

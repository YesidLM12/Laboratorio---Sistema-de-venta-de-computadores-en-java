package techmarket.model.dispositivos;

import techmarket.utils.IdGenerator;

public class Mouse extends DispositivosDeEntrada {
  private int id;
  private int cantidadBotones;
  private double precio;
  
  public Mouse(String tipo, String marca, int cantidadBotones, double precio) {
    id = IdGenerator.generarIdMouse();
    super(tipo, marca);
    this.cantidadBotones = cantidadBotones;
    this.precio = precio;
  }

  public int getIdMouse(){
    return id;
  }
  
  
  @Override
  public String toString() {
    return "Mouse: " + super.toString() + " Cantidad de botones=" + cantidadBotones + ".\n";
  }
}

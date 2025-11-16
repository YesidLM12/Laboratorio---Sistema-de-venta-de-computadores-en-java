package techmarket.model.dispositivos;

import techmarket.utils.IdGenerator;

public class Mouse extends DispositivosDeEntrada {
  private int id;
  private int cantidadBotones;
  
  public Mouse(String tipo, String marca, int cantidadBotones) {
    id = IdGenerator.nextId();
    super(tipo, marca);
    this.cantidadBotones = cantidadBotones;
  }

  public int getIdMouse(){
    return id;
  }
  
  
  @Override
  public String toString() {
    return super.toString() + " Cantidad de botones=" + cantidadBotones + ".";
  }
}

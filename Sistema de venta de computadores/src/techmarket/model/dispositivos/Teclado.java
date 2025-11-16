package techmarket.model.dispositivos;

import techmarket.utils.IdGenerator;

public class Teclado extends DispositivosDeEntrada{
  private int id;
  private String tipoTeclado;
  
  public Teclado(String tipo, String marca, String tipoTeclado) {
    id = IdGenerator.nextId();
    super(tipo, marca);
    this.tipoTeclado = tipoTeclado;
  }
  
  public Teclado(String tipo, String marca) {
    super(tipo, marca);
  }
  
  public String getTipoTeclado() {
    return tipoTeclado;
  }

  @Override
  public String toString() {
    return "Teclado: " + super.toString() + " Tipo de teclado: " + tipoTeclado + ".\n";
  }
}

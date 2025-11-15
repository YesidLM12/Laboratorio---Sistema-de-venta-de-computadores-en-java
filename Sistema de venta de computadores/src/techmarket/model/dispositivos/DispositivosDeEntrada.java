package techmarket.model.dispositivos;

import techmarket.utils.IdGenerator;

public class DispositivosDeEntrada {
  private String tipo;
  private String marca;
  
  public DispositivosDeEntrada(String tipo, String marca) {
    this.tipo = tipo;
    this.marca = marca;
  }
  
  public String getTipo() {
    return tipo;
  }
  
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  public String getMarca() {
    return marca;
  }
  
  public void setMarca(String marca) {
    this.marca = marca;
  }
  
  @Override
  public String toString() {
    return "Dispositivo de Entrada, tipo=" + tipo + ", marca=" + marca + ".";
  }
}


class mouse extends  DispositivosDeEntrada{
  private int id;
  private int cantidadBotones;
  
  public mouse(String tipo, String marca, int cantidadBotones) {
    id = IdGenerator.nextId();
    super(tipo, marca);
    this.cantidadBotones = cantidadBotones;
  }

  public int getCantidadBotones() {
    return cantidadBotones;
  }

  public void setCantidadBotones(int cantidadBotones) {
    this.cantidadBotones = cantidadBotones;
  }

  @Override
  public String toString() {
    return super.toString() + " Cantidad de botones=" + cantidadBotones + ".";
  }
}

class teclado extends DispositivosDeEntrada{
  private int id;
  private String tipoTeclado;
  
  public teclado(String tipo, String marca, String tipoTeclado) {
    id = IdGenerator.nextId();
    super(tipo, marca);
    this.tipoTeclado = tipoTeclado;
  }

  public String getTipoTeclado() {
    return tipoTeclado;
  }

  public void setTipoTeclado(String tipoTeclado) {
    this.tipoTeclado = tipoTeclado;
  }

  @Override
  public String toString() {
    return super.toString() + " Tipo de teclado=" + tipoTeclado + ".";
  }
}

class monitor extends DispositivosDeEntrada{
  private int id;
  private double tamañoPulgadas;
  
  public monitor(String tipo, String marca, double tamañoPulgadas) {
    id = IdGenerator.nextId();
    super(tipo, marca);
    this.tamañoPulgadas = tamañoPulgadas;
  }

  public double getTamañoPulgadas() {
    return tamañoPulgadas;
  }

  public void setTamañoPulgadas(double tamañoPulgadas) {
    this.tamañoPulgadas = tamañoPulgadas;
  }

  @Override
  public String toString() {
    return super.toString() + " Tamaño en pulgadas=" + tamañoPulgadas + ".";
  }
}
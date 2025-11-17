package techmarket.model.dispositivos;

import techmarket.utils.IdMonitorGenerator;

public class Monitor extends DispositivosDeEntrada {
  private final int idMonitor;
  private double tamanio;
  private double precio;

  public Monitor(String marca, double tamanio, double precio) {
    super("Monitor", marca);
    idMonitor = IdMonitorGenerator.nextId();
    this.tamanio = tamanio;
    this.precio = precio;
  }

  public int getIdMonitor() {
    return idMonitor;
  }

  public void setTamanio(double tamanio) {
    if (tamanio >= 14.9) {
      this.tamanio = tamanio;
    } else {
      IO.println("EL tamaño de pantalla debe ser mayor o igual a 14.9 pulgadas.");
    }

  }

  public void setPrecio(double precio) {
    if (precio > 0) {
      this.precio = precio;
    } else {
      IO.println("El precio debe ser mayor a $0");
    }
  }
  
  @Override
  public String toString() {
    return "Monitor: " + super.toString() + " Tamaño: " + tamanio + " pulgadas.\n";
  }
}

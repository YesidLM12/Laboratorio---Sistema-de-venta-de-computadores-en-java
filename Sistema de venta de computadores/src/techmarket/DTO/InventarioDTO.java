package techmarket.DTO;

import techmarket.model.computadora.Computadora;
import techmarket.model.dispositivos.Monitor;
import techmarket.model.dispositivos.Mouse;
import techmarket.model.dispositivos.Teclado;

import java.util.List;

public class InventarioDTO {
  private List<Monitor> monitores;
  private List<Teclado> teclados;
  private List<Mouse> mouses;
  private List<Computadora> computadoras;
  
  public InventarioDTO(List<Monitor> m, List<Teclado> t, List<Mouse> mouses,List<Computadora> computadoras ) {
    this.monitores = m;
    this.teclados = t;
    this.mouses = mouses;
    this.computadoras = computadoras;
  }
  
  public List<Mouse> getMouses() {
    return mouses;
  }
  
  public void setMouses(List<Mouse> mouses) {
    this.mouses = mouses;
  }
  
  public List<Computadora> getComputadoras() {
    return computadoras;
  }
  
  public void setComputadoras(List<Computadora> computadoras) {
    this.computadoras = computadoras;
  }
  
  public List<Teclado> getTeclados() {
    return teclados;
  }
  
  public void setTeclados(List<Teclado> teclados) {
    this.teclados = teclados;
  }
  
  public List<Monitor> getMonitores() {
    return monitores;
  }
  
  public void setMonitores(List<Monitor> monitores) {
    this.monitores = monitores;
  }
}

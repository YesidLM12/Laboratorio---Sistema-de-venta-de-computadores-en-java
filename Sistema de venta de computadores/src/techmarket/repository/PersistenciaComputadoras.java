package techmarket.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import techmarket.model.computadora.Computadora;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaComputadoras {
  private static final String RUTA = "data/computadoras.json";
  
  public void guardarLista(List<Computadora> lista){
    ArchivoManager.guardar(RUTA,lista);
  }
  
  public List<Computadora> cargarLista(){
    if (!ArchivoManager.existe(RUTA)) {
      return new ArrayList<>();
    }
    
    try (FileReader reader = new FileReader(RUTA)) {
      
      Type tipoLista = new TypeToken<List<Computadora>>() {}.getType();
      return new Gson().fromJson(reader, tipoLista);
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error al cargar la lista de computadoras", e);
    }
  }
}

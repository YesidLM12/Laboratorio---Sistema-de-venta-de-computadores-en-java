package techmarket.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import techmarket.model.computadora.Computadora;
import techmarket.services.ComputadoraService;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class PersistenciaComputadoras {
  private static final String RUTA = "data/computadoras.json";
  
  public static void guardarLista(List<Computadora> lista){
    ArchivoManager.guardar(RUTA,lista);
  }
  
  public static void cargarLista(){
    if (!ArchivoManager.existe(RUTA)) {
      return;
    }
    
    try (FileReader reader = new FileReader(RUTA)) {
      
      Type tipoLista = new TypeToken<List<Computadora>>() {}.getType();
      
      List<Computadora> listaCargada = new Gson().fromJson(reader, tipoLista);
      
      if ( listaCargada != null) {
        ComputadoraService.setComputadoras(listaCargada);
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error al cargar la lista de computadoras", e);
    }
  }
}

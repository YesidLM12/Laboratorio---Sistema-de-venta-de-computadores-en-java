package techmarket.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import techmarket.model.orden.Orden;
import techmarket.services.OrdenService;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class PersistenciaOrdenes {
  private static final String RUTA = "data/Ordenes.json";
  
  public static void guardarLista (List<Orden> lista){
    ArchivoManager.guardar(RUTA,lista);
  }
  
  public static void cargarLista (){
    if (!ArchivoManager.existe(RUTA)) {
      return;
    }
    
    try (FileReader reader = new FileReader(RUTA)) {
      
      Type tipoLista = new TypeToken<List<Orden>>() {}.getType();
      
      List<Orden> listaCargada = new Gson().fromJson(reader, tipoLista);
      
      if (listaCargada != null) {
        OrdenService.setOrdenes(listaCargada);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error al cargar la lista de computadoras", e);
    }
  }
}

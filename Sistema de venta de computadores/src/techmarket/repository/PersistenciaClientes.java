package techmarket.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import techmarket.model.cliente.Cliente;
import techmarket.services.ClienteService;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class PersistenciaClientes {
  
  private static final String RUTA = "data/Clientes.json";
  
  public static void guardarLista(List<Cliente> lista) {
    ArchivoManager.guardar(RUTA, lista);
  }
  
  public static void cargarLista() {
    if (!ArchivoManager.existe(RUTA)) {
      return;
    }
    
    try (FileReader reader = new FileReader(RUTA)) {
      
      Type tipoLista = new TypeToken<List<Cliente>>() {
      }.getType();
      
      List<Cliente> listaCargada = new Gson().fromJson(reader, tipoLista);
      
      if (listaCargada != null) {
        ClienteService.setClientes(listaCargada);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error al cargar la lista de computadoras", e);
    }
  }
}

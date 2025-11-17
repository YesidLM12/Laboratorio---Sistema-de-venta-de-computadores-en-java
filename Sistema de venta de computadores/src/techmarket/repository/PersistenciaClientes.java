package techmarket.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import techmarket.model.cliente.Cliente;
import techmarket.model.orden.Orden;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaClientes {
  private static final String RUTA = "data/Clientes.json";
  
  public void guardarLista(List<Cliente> lista) {
    ArchivoManager.guardar(RUTA, lista);
  }
  
  public List<Cliente> cargarLista() {
    if (!ArchivoManager.existe(RUTA)) {
      return new ArrayList<>();
    }
    
    try (FileReader reader = new FileReader(RUTA)) {
      
      Type tipoLista = new TypeToken<List<Cliente>>() {
      }.getType();
      return new Gson().fromJson(reader, tipoLista);
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException("Error al cargar la lista de computadoras", e);
    }
  }
}

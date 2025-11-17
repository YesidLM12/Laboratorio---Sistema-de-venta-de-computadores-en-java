package techmarket.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoManager {
  
  // =======================
  // Guardar datos en archivo
  // =======================
  
  public static void guardar(String ruta, Object objeto) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(objeto);
    
    try (FileWriter writer = new FileWriter(ruta)) {
      writer.write(json);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  
  public static <T> T cargar(String ruta, Class<T> clase) {
    Gson gson = new Gson();
    
    try (FileReader reader = new FileReader(ruta)) {
      return gson.fromJson(reader, clase);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    
  }
  
  public static boolean existe(String ruta) {
    File archivo = new File(ruta);
    return archivo.exists() && archivo.isFile();
  }
}

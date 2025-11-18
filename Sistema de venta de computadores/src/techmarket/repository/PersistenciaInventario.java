package techmarket.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import techmarket.DTO.InventarioDTO;
import techmarket.model.inventario.Inventario;

import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaInventario {
  private static final String RUTA = "data/Inventario.json";
  
 private static final Gson gson = new GsonBuilder()
         .setPrettyPrinting()
         .create();
 
 public static void guardarInvnetarioCompleto() {
   
   // Creamos el DTO con las listas actuales del inventario
   InventarioDTO dto = new InventarioDTO(
           Inventario.monitores,
           Inventario.teclados,
           Inventario.mouses,
           Inventario.computadoras
   );
   
   try(FileWriter writer = new FileWriter(RUTA)) {
     gson.toJson(dto,writer);
     System.out.println("Inventario guardado correctamente");
   } catch (IOException e) {
     System.out.println("Error al guardar el inventario: " + e.getMessage());
   }
 }
}

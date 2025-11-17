package techmarket.services;

import techmarket.model.cliente.Cliente;
import techmarket.utils.InputReader;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
  
  static List<Cliente> clientes = new ArrayList<>();
  
  // ==========================
  // Crear clientes
  // ==========================
  
  public static void crearCliente() {
    String nombreCliente = InputReader.readString("Ingrese el nombre del cliente: ");
    if (nombreCliente == null || nombreCliente.isEmpty()) {
      throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
    }
    
    Cliente cliente = new Cliente(nombreCliente.trim());
    clientes.add(cliente);
    System.out.println("Cliente creado exitosamente: " + cliente);
  }
  
  // ==========================
  // Buscar cliente por ID
  // ==========================
  
  public static void buscarClientePorId() {
    int idCliente = InputReader.readInt("Ingrese el ID del cliente a buscar: ");
    for (Cliente cliente : clientes) {
      if ( cliente.getIdCliente() == idCliente ) {
        System.out.println("Cliente encontrado: \n" + cliente);
        return;
      }
    }
  }
  
  // ==========================
  // Eliminar cliente por ID
  // ==========================
  
  public static void eliminarClientePorId() {
    int idCliente = InputReader.readInt("Ingrese el ID del cliente a eliminar: ");
    for (int i = 0; i < clientes.size(); i++) {
      if ( clientes.get(i).getIdCliente() == idCliente ) {
        System.out.println("Cliente eliminado: \n" + clientes.get(i));
        clientes.remove(i);
        return;
      }
    }
    System.out.println("No se encontró un cliente con el ID proporcionado.");
  }
  
  
  // ==========================
  // Listar todos los clientes
  // ==========================
  
  public static void listarClientes() {
    if (clientes.isEmpty()) {
      System.out.println("No hay clientes registrados.");
      return;
    }
    
    System.out.println("\n--- Lista de Clientes ---");
    for (Cliente cliente : clientes) {
      System.out.println(cliente);
    }
  }
}

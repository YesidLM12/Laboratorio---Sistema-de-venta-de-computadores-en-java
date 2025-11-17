package techmarket.services;

import techmarket.model.cliente.Cliente;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
  
  List<Cliente> clientes = new ArrayList<>();
  
  // ==========================
  // Crear clientes
  // ==========================
  
  public Cliente crearCliente(String nombreCliente) {
    if (nombreCliente == null || nombreCliente.isEmpty()) {
      throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
    }
    
    Cliente cliente = new Cliente(nombreCliente.trim());
    clientes.add(cliente);
    
    return cliente;
  }
  
  // ==========================
  // Buscar cliente por ID
  // ==========================
  
  public Cliente buscarClientePorId(int idCliente) {
    for (Cliente cliente : clientes) {
      if ( cliente.getIdCliente() == idCliente ) {
        return cliente;
      }
    }
    return null;
  }
  
  // ==========================
  // Listar todos los clientes
  // ==========================
  
  public List<Cliente> listarClientes() {
    return clientes;
  }
}

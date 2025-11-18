package techmarket.view;

import techmarket.DTO.InventarioDTO;
import techmarket.model.computadora.Computadora;
import techmarket.model.inventario.Inventario;
import techmarket.repository.PersistenciaClientes;
import techmarket.repository.PersistenciaComputadoras;
import techmarket.repository.PersistenciaInventario;
import techmarket.repository.PersistenciaOrdenes;
import techmarket.services.ClienteService;
import techmarket.services.ComputadoraService;
import techmarket.services.Inventarioservice;
import techmarket.services.OrdenService;
import techmarket.utils.InputReader;

import javax.naming.InvalidNameException;

public class MenuApp {
  
  private final ComputadoraService computadoraService = new ComputadoraService();
  private final Inventarioservice inventarioservice = new Inventarioservice();
  private final ClienteService clienteService = new ClienteService();
  private final OrdenService ordenService = new OrdenService();
  
  
  public void iniciar(){
    cargarDatos();
    mostrarMenuPrincipal();
    guardarDatos();
  }
  
  
  private void mostrarMenuPrincipal(){
    int opcion;
    
    do {
      System.out.println("\n===== SISTEMA DE VENTAS TECHMARKET =====");
      System.out.println("1. Gestión de inventario");
      System.out.println("2. Gestión de clientes");
      System.out.println("3. Crear computadora");
      System.out.println("4. Crear orden");
      System.out.println("5. Mostrar órdenes");
      System.out.println("6. Buscar");
      System.out.println("0. Salir");
      
      opcion = InputReader.readInt("Seleccione una opción: ");
      
      switch (opcion) {
        case 1 -> opcionGestionInventario();
        case 2 -> opcionGestionClientes();
        case 3 -> opcionCrearComputadora();
        case 4 -> opcionCrearOrden();
        case 5 -> opcionMostrarOrdenes();
        case 6 -> opcionBuscar();
        case 0 -> System.out.println("Saliendo del sistema. ¡Hasta luego!");
        default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
      }
    } while (opcion != 0);
  }
  
  
  
  private void opcionGestionInventario(){
    int opcion;
    
    do {
      System.out.println("\n--- Gestión de Inventario ---");
      System.out.println("1. Listar Inventario");
      System.out.println("2. Agregar Teclado");
      System.out.println("3. Agregar Mouse");
      System.out.println("4. Agregar Monitor");
      System.out.println("5. Agregar Computadora");
      System.out.println("6. Eliminar Teclado");
      System.out.println("7. Eliminar Mouse");
      System.out.println("8. Eliminar Monitor");
      System.out.println("0. Volver");
      
      opcion = InputReader.readInt("Seleccione una opción: ");
      
      switch (opcion) {
         case 1 -> Inventarioservice.mostrarInventario();
         case 2 -> inventarioservice.agregarStockTeclado();
         case 3 -> inventarioservice.agregarStockMouse();
         case 4 -> inventarioservice.agregarStockMonitor();
         //case 5 -> inventarioservice.agregarStockComputadora();
         case 6 -> Inventarioservice.eliminarTeclado();
         case 7 -> Inventarioservice.eliminarMouse();
         case 8 -> Inventarioservice.eliminarMonitor();
         case 0 -> System.out.println("Volviendo al menú principal.");
         default -> System.out.println("Opción inválida.");
      }
    } while (opcion != 0);
  }
  
  
  private void opcionGestionClientes(){
    int opcion;
    
    do {
      System.out.println("\n--- Gestión de Clientes ---");
      System.out.println("1. Listar Clientes");
      System.out.println("2. Agregar Cliente");
      System.out.println("3. Buscar Cliente por ID");
      System.out.println("4. Eliminar Cliente");
      System.out.println("0. Volver");
      
      opcion = InputReader.readInt("Seleccione una opción: ");
      
      switch (opcion) {
         case 1 -> ClienteService.listarClientes();
         case 2 -> ClienteService.crearCliente();
         case 3 -> ClienteService.buscarClientePorId();
         case 4 -> ClienteService.eliminarClientePorId();
         case 0 -> System.out.println("Volviendo al menú principal.");
         default -> System.out.println("Opción inválida.");
      }
    } while (opcion != 0);
  
  }
  
  
  private void opcionCrearComputadora(){
    int opcion;
    
    do {
      System.out.println("\n--- Crear Computadora ---");
      System.out.println("1. Crear Computadora Prediseñada");
      System.out.println("2. Crear Computadora Gamer");
      System.out.println("3. Crear Computadora para ofinomatica");
      System.out.println("4. Crear Computadora para estudiantes");
      System.out.println("0. Volver");
      
      opcion = InputReader.readInt("Seleccione una opción: ");
      
      switch (opcion) {
         case 1 -> computadoraService.crearComputadora();
         case 2 -> computadoraService.crearComputadoraGamer();
         case 3 -> computadoraService.crearComputadoraOfimatica();
         case 4 -> computadoraService.crearComputadoraEstudiante();
         case 0 -> System.out.println("Volviendo al menú principal.");
         default -> System.out.println("Opción inválida.");
      }
    } while (opcion != 0);
  
  }
  
  
  private void opcionCrearOrden(){
    int opcion;
    
    do {
      System.out.println("\n--- Crear Orden ---");
      System.out.println("1. Crear Orden para Cliente Existente");
      System.out.println("2. Crear Orden para Nuevo Cliente");
      System.out.println("0. Volver");
      
      opcion = InputReader.readInt("Seleccione una opción: ");
      
      switch (opcion) {
         case 1 -> ordenService.crearOrdenClienteExistente();
         case 2 -> ordenService.crearOrdenClienteNuevo();
         case 0 -> System.out.println("Volviendo al menú principal.");
         default -> System.out.println("Opción inválida.");
      }
    } while (opcion != 0);
  
  }
  
  
  private void opcionMostrarOrdenes(){
    int idOrden = InputReader.readInt("Ingresa el id de la orden: ");
    String detalles = OrdenService.mostrarDetallesOrden(idOrden);
    System.out.println(detalles);
  }
  
  
  private void opcionBuscar(){
    int opcion;
    
    do {
      System.out.println("\n ----------- Buscar -----------");
      System.out.println("1. Buscar cliente");
      System.out.println("2. Buscar orden");
      System.out.println("3. Buscar computadora");
      System.out.println("4. Buscar teclado");
      System.out.println("5. Buscar mouse");
      System.out.println("6. Buscar monitor");
      System.out.println("0. Salir");
      
      opcion = InputReader.readInt("Selecciona una opción: ");
      
      switch (opcion) {
        case 1 -> ClienteService.buscarClientePorId();
        case 2 -> OrdenService.buscarOrdenPorId();
        case 3 -> ComputadoraService.buscarComputadoraPorId();
        case 4 -> Inventarioservice.buscarTecladoPorId();
        case 5 -> Inventarioservice.buscarMousePorId();
        case 6 -> Inventarioservice.buscarMonitorPorId();
        case 0 -> System.out.println("Volviendo al menú principal.");
        default -> System.out.println("Opción no válida.");
      }
      
    }while(opcion != 0);
    
  }
  
  
  private void cargarDatos(){
    System.out.println("Cargando datos...");
    PersistenciaClientes.cargarLista();
    PersistenciaComputadoras.cargarLista();
    PersistenciaOrdenes.cargarLista();
  }
  
  private void guardarDatos() {
    PersistenciaClientes.guardarLista(ClienteService.getClientes());
    PersistenciaComputadoras.guardarLista(Computadora.getComputadoras());
    PersistenciaOrdenes.guardarLista(OrdenService.getOrdenes());
    PersistenciaInventario.guardarInvnetarioCompleto();
  }
}

# Laboratorio - Sistema de venta de computadores en java
Trabajo final de Construcción de software I

## Estructura del proyecto

src/        
└── techmarket/     
├── app/        
│     └── VentaComputadoresApp.java     
│       
├── model/      
│     ├── dispositivos/     
│     │       ├── DispositivoEntrada.java       
│     │       ├── Teclado.java      
│     │       ├── Raton.java        
│     │       └── Monitor.java      
│     │     
│     ├── computadora/      
│     │       └── Computadora.java      
│     │     
│     ├── orden/        
│     │       ├── Orden.java        
│     │       └── DetalleOrden.java  (opcional)     
│     │     
│     ├── cliente/      
│     │       └── Cliente.java      
│     │     
│     └── inventario/       
│             └── Inventario.java       
│       
├── service/            
│     ├── ComputadoraService.java       
│     ├── OrdenService.java     
│     ├── ClienteService.java       
│     └── InventarioService.java        
│       
├── repository/     
│     ├── ArchivoManager.java       
│     ├── PersistenciaComputadoras.java     
│     ├── PersistenciaOrdenes.java      
│     └── PersistenciaClientes.java     
│       
├── utils/      
│     ├── InputReader.java      
│     ├── IdGenerator.java      
│     └── Validador.java        
│
└── view/
└── MenuApp.java

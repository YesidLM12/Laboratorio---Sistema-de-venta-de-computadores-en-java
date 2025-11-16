# Laboratorio - Sistema de venta de computadores en java
## Descripción del proyecto
Este laboratorio tiene como objetivo aplicar los principios  fundamenteales de Programación Orientada a Objetos para modelar un sitema de venta de computadores. El proyecto incluye el diseño e implementación de clases usando herencia, composición, encapsulamiento y manejo de objetos relacionados entre sí.

## Estructura del proyecto

El sistema está compuesto por las siguientes clases principales: 
- **DispositivoEntrada**: Clase base para dispositivos de entrada como teclado y mouse.
- **Teclado y mouse**: Clase que representa un teclado, hereda de DispositivoEntrada e incluyen un ID único.
- **Monitor**: Clase que representa un monitor con atributos como marca y tamaño.
- **Computadora**: Clase que representa una computadora compuesta por un monitor, teclado y mouse.
- **Orden**: Clase que representa una orden de compra que puede contener múltiples computadoras y mostrarlas.
- **Cliente**: Clase que representa un cliente con atributos como nombre y ID único.
- **Inventario**: Clase que gestiona el inventario de computadoras disponibles para la venta.

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


## Diagrama de relaciones 
![Diagrama de clases](Sistema%20de%20venta%20de%20computadores/public/Diagrama%20ULM%20sistema%20vemta%20de%20computadores.png)

- Teclado -> hereda de -> DispositivoEntrada
- Mouse -> hereda de -> DispositivoEntrada
- Computadora -> tiene -> Monitor
- Computadora -> tiene -> Teclado
- Computadora -> tiene -> Mouse
- Orden -> tiene -> Computadora (relación de agregación)
- Orden -> tiene -> Cliente (relación de agregación)
- Inventario -> tiene -> Computadora (relación de agregación)

## Casos de prueba Realizados
Se ejecutaron casos de uso para comprobar el correcto funcionamiento del sistema: 
- Creación de dispositivos individuales
- Validación de Ids autoincrementales
- Construcción de computadores completos
- Gestión de órdenes con múltiples computadores
- Reutilización de componentes
- Impresión de información mediante toString()

## Evidencia y Resultados
El programa compila correctamente y genera salidas coherentes  que reflejan la estructura de los objetos creados. Cada prueba evidencia que las clases se relacionan correctamente mediante herencia y composición.

## AUTOR
- **Nombre**: Yesid F. Londoño Martinez.

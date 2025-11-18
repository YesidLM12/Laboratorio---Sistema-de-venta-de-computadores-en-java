# Laboratorio - Sistema de venta de computadores en java
## Descripción del proyecto
Este laboratorio tiene como objetivo aplicar los principios fundamentales de Programación Orientada a Objetos (POO) para modelar un sistema de venta de computadores.
El proyecto integra conceptos como herencia, composición, encapsulamiento, manejo de listas, modularización y separación de responsabilidades mediante el uso de servicios y repositorios.

La aplicación simula el funcionamiento básico de una tienda de equipos de cómputo: permite gestionar dispositivos, ensamblar computadoras, administrar clientes, registrar órdenes de compra, manejar inventario y persistir información. Todo esto desde una interfaz interactiva por consola.

## Funcionalidades principales
El sistema permite:

- Crear dispositivos: monitores, ratones y teclados.

- Registrar clientes con información básica.

- Construir computadoras combinando distintos dispositivos.

- Gestionar inventario y validar disponibilidad.

- Registrar órdenes de compra asociadas a un cliente.

- Calcular valores totales de computadoras y órdenes.

- Mostrar información detallada de cada objeto mediante toString().

- Guardar y cargar datos persistentes mediante archivos.

- Interactuar con el sistema a través de un menú en consola.

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
Durante el desarrollo se ejecutaron diferentes pruebas para garantizar el correcto funcionamiento del sistema:

- reación y visualización de dispositivos individuales.

- Validación del sistema de IDs autoincrementales.

- Construcción de computadoras completas mediante composición.

- Gestión de órdenes con múltiples computadoras.

- Asociación de órdenes a clientes.

- Validación de stock disponible en el inventario.

- Impresión detallada de la información usando toString().

- Ensayos del menú interactivo para registrar y consultar datos.

- Pruebas de persistencia: guardar y cargar datos desde archivo.

## Evidencia y Resultados
El programa compila correctamente y genera salidas coherentes  que reflejan la estructura de los objetos creados. Cada prueba evidencia que las clases se relacionan correctamente mediante herencia y composición.

## AUTOR
- **Nombre**: Yesid F. Londoño Martinez.

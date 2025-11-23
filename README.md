# Laboratorio - Sistema de venta de computadores en java
## Descripción del proyecto
Este laboratorio tiene como objetivo aplicar los principios fundamentales de Programación Orientada a Objetos (POO) para modelar un sistema de venta de computadores.
El proyecto integra conceptos como herencia, composición, encapsulamiento, manejo de listas, modularización y separación de responsabilidades mediante el uso de servicios y repositorios.

La aplicación simula el funcionamiento básico de una tienda de equipos de cómputo: permite gestionar dispositivos, ensamblar computadoras, administrar clientes, registrar órdenes de compra, manejar inventario y persistir información. Todo esto desde una interfaz interactiva por consola.

- ***El proyecto fue desarrollado con el SDK Java SE 25***

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

### Capturas de pantalla

- Menú principal

![Menu principal](Sistema%20de%20venta%20de%20computadores/public/assets/Menu%20principal.png)

- Menú gestion de inventario

![Menú gestion de inventario](Sistema%20de%20venta%20de%20computadores/public/assets/Menu%20gestion%20de%20inventario.png)

- Respuesta listar inventario vacio

![respuesta inventario vacio](Sistema%20de%20venta%20de%20computadores/public/assets/Respuesta%20listar%20inventario%20vacio.png)

- Respuesta agregar teclado

![respuesta agregar teclado](Sistema%20de%20venta%20de%20computadores/public/assets/opcion%202%20agregar%20teclado.png)

- Respuesta al eliminar tecladoo

![eliminar teclado](Sistema%20de%20venta%20de%20computadores/public/assets/Respuesta%20al%20eliminar%20teclado.png)

- Respuesta inventario

![inventario](Sistema%20de%20venta%20de%20computadores/public/assets/Respuesta%20listar%20inventario%20lleno.png)

- Menú gestion de clientes

![menu clientes](Sistema%20de%20venta%20de%20computadores/public/assets/Menu%20clientes.png)

- Respuesta agregar cliente

![agregar cliente](Sistema%20de%20venta%20de%20computadores/public/assets/Respuesta%20agregar%20cliente.png)

- Respuesta buscar cliente por ID

![buscar por id](Sistema%20de%20venta%20de%20computadores/public/assets/Respuesta%20buscar%20cliente%20por%20ID.png)

- Respuesta eliminar cliente

![eliminar cliente](Sistema%20de%20venta%20de%20computadores/public/assets/Respuesta%20al%20eliminar%20cliente.png)

- Menú crear computadora

![menu crear computadora](Sistema%20de%20venta%20de%20computadores/public/assets/Menu%20crear%20computadora.png)

- respuesta crear computadora

![respuesta crea computadora](Sistema%20de%20venta%20de%20computadores/public/assets/Respuesta%20crear%20computadora%20prediseñada.png)

- Menú crear orden

![Menú crear orden](Sistema%20de%20venta%20de%20computadores/public/assets/Menu%20crear%20orden.png)

- Respuesta crear orden 

![Respuesta crea orden](Sistema%20de%20venta%20de%20computadores/public/assets/Respuesta%20crear%20orden.png)

## Autores
- **Nombre**: Yesid F. Londoño Martinez.
- **Nombre**: Erica johana valoyes vivas
- -- **Nombre**: Wilderm Mateo Zapata

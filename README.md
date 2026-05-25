# 📌 Plataforma de Gestión de Eventos y Venta de Entradas

---

## 👥 Integrantes del proyecto

- Nicolás Santiago Guzmán Chala  
- Yulian Stiven Díaz Pulido  
- Juan Esteban Campos Cardona  

---

# 📖 Descripción del proyecto

Este proyecto consiste en el desarrollo de una plataforma de gestión de eventos y venta de entradas, diseñada para facilitar la administración de eventos y la compra de boletos por parte de los usuarios.

El sistema permite:
- Explorar eventos disponibles
- Seleccionar asientos por zona
- Realizar compras con múltiples métodos de pago
- Aplicar servicios adicionales a la compra
- Gestionar estados de las compras
- Generar reportes en distintos formatos
- Manejar incidencias dentro del sistema
- Notificar cambios a usuarios y servicios del sistema

---

# ❗ Problema que resuelve el sistema

En la actualidad, la gestión de eventos y venta de entradas suele estar fragmentada entre múltiples sistemas o procesos manuales, lo que genera:

- Dificultad en la administración de eventos
- Falta de control sobre la disponibilidad de asientos
- Procesos de compra poco flexibles
- Poca trazabilidad de incidencias y reembolsos
- Limitada personalización de servicios adicionales
- Falta de integración entre módulos del sistema

---

# 💡 Solución propuesta

Se propone una plataforma centralizada que permite:

- Gestionar eventos, recintos y zonas de forma estructurada
- Automatizar el proceso de compra de entradas
- Permitir extensibilidad mediante patrones de diseño
- Generar reportes en distintos formatos (PDF y CSV)
- Manejar estados dinámicos de las compras
- Notificar cambios en tiempo real a los usuarios del sistema

---

# 📁 Estructura del proyecto

El proyecto se encuentra organizado en:

src/main/java/co/edu/uniquindio/poo/evenly/

Paquetes principales:
- model/ → Entidades del sistema (Compra, Event, User, etc.)
- Observer/ → Patrón Observer
- Proxy/ → Control de acceso a compras
- CompraDecorator/ → Servicios adicionales a la compra
- CompraStatePackage/ → Estados de la compra
- Factory/ → Creación de eventos
- ENUMS/ → Enumeraciones
- service/ → Lógica del negocio

Documentación:

DOCUMENTACION DEL PROYECTO/

Contiene:
- Pensamiento computacional
- Diagramas UML
- Justificación de patrones de diseño
- Evidencia del diseño arquitectónico

---

# ⚙️ Instrucciones para ejecutar el proyecto

Requisitos:
- Java 17+
- Maven
- JavaFX configurado
- IDE recomendado: IntelliJ IDEA

Ejecución:
1. Clonar el repositorio:
git clone <URL_DEL_REPOSITORIO>

2. Abrir el proyecto en el IDE.

3. Ejecutar:
EvenlyApplication.java

4. Asegurarse de tener JavaFX configurado correctamente.

---

# 🧠 Patrones de diseño implementados

---

## 🏭 Factory Method 

Problema:
Se necesita crear distintos tipos de eventos sin acoplar la lógica de creación.

Solución:
Se encapsula la creación en fábricas específicas.

Propósito:
Desacoplar la creación de objetos.

---

## 🌳 Composite

Problema:
Representar estructuras jerárquicas como recinto → zonas → asientos.

Solución:
Se usa una estructura en árbol donde todos los elementos se tratan de forma uniforme.

Propósito:
Tratar objetos individuales y compuestos de forma homogénea.

---

## 🎁 Decorator

Problema:
Agregar servicios adicionales a una compra sin modificar su clase base.

Solución:
Se envuelve la compra con funcionalidades adicionales dinámicamente.

Propósito:
Extender comportamiento sin modificar código existente.

---

## 👀 Observer

Problema:
Notificar cambios en compras, eventos e incidencias.

Solución:
Se implementa un sistema de suscriptores que reaccionan a cambios.

Propósito:
Desacoplar emisores y receptores de eventos.

---

## 🔌 Adapter

Problema:
Generar reportes en formatos incompatibles (PDF y CSV).

Solución:
Se unifica el acceso mediante una interfaz común.

Propósito:
Integrar sistemas distintos (PDFBox y CSV).

---

## 🔄 Strategy

Problema:
Soportar múltiples métodos de pago.

Solución:
Cada método de pago es una estrategia independiente.

Propósito:
Permitir cambiar algoritmos en tiempo de ejecución.

---

## 🔁 State

Problema:
Una compra cambia su comportamiento según su estado.

Solución:
Cada estado encapsula su lógica.

Propósito:
Evitar condicionales complejos.

---

## 🔐 Proxy

Problema:
Control de acceso a operaciones sensibles.

Solución:
Se crea un proxy que valida antes de ejecutar.

Propósito:
Seguridad y control de acceso.

---

## 📋 Prototype

Problema:
Clonar estructuras de reportes sin recrearlas.

Solución:
Se implementa clonación de objetos.

Propósito:
Optimizar creación de objetos complejos.

---

# 🧱 Principios SOLID aplicados

---

## S - Single Responsibility Principle
Cada clase tiene una sola responsabilidad (CompraService, EventService, UserService).

## O - Open/Closed Principle
El sistema se puede extender sin modificar código (nuevos estados, pagos, decoradores).

## L - Liskov Substitution Principle
Las implementaciones pueden sustituir sus interfaces (estrategias de pago, estados).

## I - Interface Segregation Principle
Interfaces específicas y pequeñas (Observer, State, Strategy).

## D - Dependency Inversion Principle
El sistema depende de abstracciones, no de implementaciones concretas.

---

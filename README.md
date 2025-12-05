# Buscaminas en Consola (Java)

## Descripción
Este proyecto es una implementación en consola del clásico juego **Buscaminas**, desarrollado en Java utilizando **Programación Orientada a Objetos (POO)** y el patrón **MVC**.  
El juego permite descubrir casillas, marcar minas y gestiona condiciones de victoria y derrota.

---

## Características
- Tablero de 10x10 con 10 minas colocadas aleatoriamente.
- Descubrimiento automático de casillas vacías adyacentes.
- Marcado de casillas sospechosas de contener minas.
- Manejo de excepciones para entradas inválidas o casillas ya descubiertas.
- Código organizado por paquetes: `model`, `view`, `controller`, `exceptions`.

---
## Instalación & Uso

### Requisitos
- Tener instalado **Java JDK 25** (o versión compatible).  
- Tener los archivos del proyecto descargados o clonados en tu equipo.

### Pasos para ejecutar

```bash
git clone https://github.com/tecgetta777/EXAMEN-PRACTICO.git
cd EXAMEN-PRACTICO/src
javac model/*.java view/*.java controller/*.java exceptions/*.java Main.java
java Main

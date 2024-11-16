# Bomber Man Game en Consola

Este proyecto es una implementación en Java del clásico juego **Bomber Man**, adaptado para jugar en la consola.
Los jugadores pueden interactuar con una matriz que representa el terreno del juego, colocar bombas y calcular su impacto en las casillas adyacentes.

## 📜 Descripción del Proyecto

El objetivo principal de este juego es practicar habilidades de programación en Java, 
como la manipulación de matrices, validación de entrada del usuario y el uso de estructuras de control como bucles y condiciones.
El juego genera un terreno aleatorio (una matriz de tamaño definido por el usuario) y permite realizar acciones como mostrar la matriz y colocar bombas que afectan las casillas seleccionadas.

## ⚙️ Funcionalidades

### 1. **Generación Dinámica del Terreno**
   - El usuario define el tamaño del terreno indicando el número de filas y columnas.
   - La matriz se rellena con números aleatorios del 1 al 9, representando valores en las casillas.

### 2. **Opciones del Menú Principal**
   - **[0] Salir:** Finaliza el juego.
   - **[1] Mostrar la Matriz:** Muestra el estado actual del terreno.
   - **[2] Poner la Bomba:** Permite colocar una bomba en una casilla específica.

### 3. **Colocación de Bombas**
   - El jugador ingresa las coordenadas de la casilla donde desea colocar una bomba.
   - El valor de la explosión se calcula como la suma de los valores de las casillas afectadas en la fila y la columna (sin contar dos veces la casilla central).
   - Todas las casillas afectadas se convierten en `0` tras la explosión.

### 4. **Final del Juego**
   - El juego verifica si todas las casillas del terreno se han convertido en `0` tras una explosión. Si esto ocurre, muestra un mensaje indicando que el terreno está vacío y termina el juego.



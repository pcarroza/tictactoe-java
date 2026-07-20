# Vista de Procesos

Responde a: ¿qué ocurre en tiempo de ejecución? ¿hay concurrencia, hilos, sincronización?

`hilo-unico.puml` es el diagrama de esta vista: el único hilo (`main`) recorriendo el bucle de menú y el bucle de partida, con E/S bloqueante en cada paso. Muestra explícitamente por qué el reloj de 15s (`TimedPlacementController`) no necesita sincronización — el chequeo del deadline ocurre en el mismo hilo, justo después de que el `read()` bloqueante retorna, no en un hilo de reloj separado.

**Deliberadamente delgada en este proyecto.** La app es de un solo hilo: bucle de juego síncrono (`GameModule.run()`), entrada/salida bloqueante por consola (`Terminal`). No hay nada que sincronizar hoy.

Ganaría contenido real si en el futuro se implementara enforcement con interrupción real de la espera de consola (descartado en el reloj por turno por invasivo) o un módulo de partida en red.

# Vista de Procesos

Responde a: ¿qué ocurre en tiempo de ejecución? ¿hay concurrencia, hilos, sincronización?

**Deliberadamente delgada en este proyecto.** La app es de un solo hilo: bucle de juego síncrono (`GameFeature.run()`), entrada/salida bloqueante por consola (`Terminal`). No hay nada que sincronizar hoy.

Ganaría contenido real si en el futuro se implementara enforcement con interrupción real de la espera de consola (descartado en el reloj por turno por invasivo) o una feature de partida en red.

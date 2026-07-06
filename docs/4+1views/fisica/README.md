# Vista Física

Responde a: ¿en qué máquinas/procesos se despliega esto?

**Deliberadamente delgada en este proyecto.** Un único proceso JVM en una única máquina; sin red, sin base de datos, sin nodos distribuidos — se ejecuta con `./gradlew run`.

Solo cobraría contenido real con una arquitectura cliente-servidor (por ejemplo, la propuesta de "partida remota" que se descartó por complejidad frente al alcance educativo del proyecto).

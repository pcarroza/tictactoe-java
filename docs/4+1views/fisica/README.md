# Vista Física

Responde a: ¿en qué máquinas/procesos se despliega esto?

`despliegue.puml` es el diagrama de esta vista: un único nodo (la máquina del jugador) con la JVM, la terminal y los artefactos de persistencia según `PersistenceType`.

**Deliberadamente delgada en este proyecto.** Un único proceso JVM en una única máquina; sin red, sin nodos distribuidos — se ejecuta con `./gradlew run`.

**Persistencia (`PersistenceType.SQLITE`, configurado en `TicTacToeApp`)**: SQLite embebido vía `sqlite-jdbc` — no es un servidor de base de datos aparte, corre en el mismo proceso JVM y persiste en un único archivo local (`data/*.db`, ver `SqliteSupport`/`Sqlite*DaoFactory`). No introduce un nodo ni un proceso nuevo; la tesis de "todo en un único proceso" se mantiene. Las alternativas `FILE`/`JSON` (serialización a disco) e `IN_MEMORY` (sin persistencia) comparten la misma característica.

Solo cobraría contenido real con una arquitectura cliente-servidor (por ejemplo, la propuesta de "partida remota" que se descartó por complejidad frente al alcance educativo del proyecto) o con una base de datos servidor (Postgres/MySQL) en vez de SQLite embebido.

# Vista Lógica

Responde a: ¿qué piezas hay en el sistema y cómo se relacionan funcionalmente? (clases, interfaces, paquetes, patrones).

Organizada en 3 subcarpetas por tipo de diagrama:

- `paquetes/` — la vista de más alto nivel (el DAG de capas).
- `patrones/` — un diagrama de clases por cada mecanismo central de la arquitectura.
- `estados/` — la estructura de clases de las máquinas de estado y sus diagramas de estado nativos (comportamiento).

| Archivo | Qué muestra | Fuente en el código |
|---|---|---|
| `paquetes/paquetes-capas.puml` | DAG de 6 paquetes raíz (`events`, `libs`, `models`, `controllers`, `views`, `core`) sin ciclos | `CLAUDE.md`, `.agents/design/package-dependency.md` |
| `patrones/patron-visitor.puml` | Las 3 cadenas de doble despacho (turno → colocar/mover → coordenada) | `controllers/features/game/*Controller*Visitor*.java` |
| `patrones/patron-strategy-ia.puml` | Selección de dificultad de la IA (`AiDifficulty`) y las dos estrategias (`RandomAiStrategy`, `MinimaxAiStrategy`) | `controllers/features/game/local/ai/` |
| `patrones/patron-dao-persistencia.puml` | Abstract Factory de `DaoFactory` (in-memory/file/json/sqlite), Strategy de `FileCodec` y capa de servicio | `models/persistence/` |
| `patrones/patron-decorator.puml` | Los dos árboles de Decorator del proyecto: vistas (`ViewDecorator`) y el reloj por turno (`TimedPlacementController`) | `views/console/features/game/decorator/`, `controllers/features/game/local/` |
| `patrones/patron-observer-y-eventos.puml` | Contraste entre Observer (transiciones intra-turno, `Board`↔`LocalGameLogic`) y Event Bus (comunicación cross-feature, `EventManager`) | `models/features/game/Subject.java`, `events/EventManager.java` |
| `patrones/patron-command.puml` | Jerarquía `Command`/`Menu` que arma el menú principal | `views/console/core/commands/`, `views/console/core/menus/` |
| `estados/patron-estado.puml` | Máquina de estados completa: Initial, InGame, End, Save, Undo, Redo, Exit | `controllers/features/game/local/logic/` |
| `estados/diagrama-estados-partida.puml` | Diagrama de estados nativo (comportamiento) de la partida — complementa `patron-estado.puml` (estructura de clases) | `controllers/features/game/local/logic/` |
| `estados/diagrama-estados-repeticion.puml` | Diagrama de estados nativo de la repetición | `controllers/features/replay/local/logic/` |

Cada clase y método mostrado se verificó leyendo el código actual antes de dibujarlo — ninguna relación es especulativa.

# Vista Lógica

Responde a: ¿qué piezas hay en el sistema y cómo se relacionan funcionalmente? (clases, interfaces, paquetes, patrones).

`paquetes-capas.puml` da la vista general (el DAG de capas de `CLAUDE.md`); cada `patron-*.puml` detalla, a nivel de clase, uno de los mecanismos centrales de la arquitectura.

| Archivo | Qué muestra | Fuente en el código |
|---|---|---|
| `paquetes-capas.puml` | DAG de 6 paquetes raíz (`events`, `libs`, `models`, `controllers`, `views`, `core`) sin ciclos | `CLAUDE.md`, `.agents/design/package-dependency.md` |
| `patron-visitor.puml` | Las 3 cadenas de doble despacho (turno → colocar/mover → coordenada) | `controllers/features/game/*Controller*Visitor*.java` |
| `patron-estado.puml` | Máquina de estados completa: Initial, InGame, End, Save, Undo, Redo, Exit | `controllers/features/game/local/logic/` |
| `diagrama-estados-partida.puml` | Diagrama de estados nativo (comportamiento) de la partida — complementa `patron-estado.puml` (estructura de clases) | `controllers/features/game/local/logic/` |
| `diagrama-estados-repeticion.puml` | Diagrama de estados nativo de la repetición — máquina no documentada hasta ahora | `controllers/features/replay/local/logic/` |
| `patron-decorator.puml` | Los dos árboles de Decorator del proyecto: vistas (`ViewDecorator`) y el reloj por turno (`TimedPlacementController`) | `views/console/features/game/decorator/`, `controllers/features/game/local/` |
| `patron-observer-y-eventos.puml` | Contraste entre Observer (transiciones intra-turno, `Board`↔`LocalGameLogic`) y Event Bus (comunicación cross-feature, `EventManager`) | `models/features/game/Subject.java`, `events/EventManager.java` |
| `patron-command.puml` | Jerarquía `Command`/`Menu` que arma el menú principal | `views/console/core/commands/`, `views/console/core/menus/` |

Cada clase y método mostrado se verificó leyendo el código actual antes de dibujarlo — ninguna relación es especulativa.

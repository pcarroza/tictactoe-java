# Features Propuestas — TicTacToe Java

Catálogo de features educativas para ampliar el proyecto. Cada una introduce un patrón de diseño nuevo o profundiza en los existentes.

---

## Estado

| # | Feature | Patrón principal | Estado |
|---|---------|-----------------|--------|
| 1 | Replay de partida | Iterator | ✅ Implementada |
| 2 | Modo de tablero variable | Strategy | ⬜ Pendiente |
| 3 | Lógica en red | Proxy | ⬜ Pendiente |
| 4 | Validación por cadena | Chain of Responsibility | ✅ Implementada |
| 5 | Vista decorada | Decorator | ✅ Implementada |
| 6 | Perfiles de jugador | Singleton + DAO | ✅ Implementada |
| 7 | Logros | Observer (Event Bus) | ✅ Implementada |
| 8 | Reloj por turno | Decorator | ✅ Implementada |
| 9 | IA con dificultad (EASY/HARD) | Strategy | ✅ Implementada |
| 10 | Persistencia real (File/JSON/SQLite) | DAO + Abstract Factory | ✅ Implementada |

Features 7–10 no estaban en el catálogo original; se añadieron sobre la marcha y se documentan aquí para que la tabla de estado refleje el código real.

---

## 1. Replay de Partida ✅

**Patrón introducido:** Iterator  
**Patrón que profundiza:** Memento, State Machine, Visitor

### Descripción
Permite reproducir una partida guardada movimiento a movimiento, con soporte para avanzar y retroceder.

### Flujo
```
MainMenu → Reproducir Partida
  └─► Selección de partida (LocalLoadController + ConsoleLoadView)
  └─► Loop de replay (LocalReplayLogic + ConsoleReplayView)
```

### Máquina de estados
```
ShowMoveReplayState ──[next()]────► ShowMoveReplayState
                    ──[previous()]► ShowMoveReplayState
                    ──[exit()]────► ExitReplayState (null → termina loop)
```

### Iterator en acción
`ReplayStatesBuilder.collectRecords()` itera `MoveHistory` con `MoveHistoryIterator`:
```java
for (MoveRecord record : history) {   // usa MoveHistoryIterator
    list.add(record);
}
```

### Archivos creados
```
controllers/features/replay/
  ReplayController.java
  ReplayControllerVisitor.java
  local/
    LocalReplayLogic.java
    LocalReplayController.java
    ReplayBoard.java
    ReplayState.java (abstract)
    ShowMoveReplayState.java
    ExitReplayState.java
    ReplayStatesBuilder.java
views/core/ReplayView.java
views/console/features/replay/ConsoleReplayView.java
core/features/ReplayFeature.java
views/console/core/commands/ReplayGameCommand.java
```

### Archivos modificados
- `GameSnapshot` — añadido campo `MoveHistory history`
- `LocalSaveController` — guarda historial al hacer save
- `ViewType` — añadido `createReplayView()`
- `MainMenu`, `TicTacToeApp` — wiring

---

## 2. Modo de Tablero Variable (NxN, K en raya)

**Patrón introducido:** Strategy (WinCondition)  
**Patrón que profundiza:** Abstract Factory, Builder

### Descripción
Parametrizar el tamaño del tablero (3x3, 4x4, 5x5) y la condición de victoria (K fichas en línea). El usuario elige al iniciar una nueva partida.

### Diseño propuesto
```java
// Nueva interfaz en controllers/core/
interface WinCondition {
    boolean evaluate(Board board);
}

// Implementaciones
class ThreeInARowWin implements WinCondition { ... }
class FourInARowWin implements WinCondition { ... }
```

- `Coordinate.DIMENSION` deja de ser constante → configurable por partida
- `AppConfig` incluye dimensión y condición de victoria
- `LocalStartController` ofrece menú de configuración antes de empezar
- `GameStatesBuilder` recibe la configuración y construye el estado inicial apropiado

### Impacto
- `Board` — dimensión parametrizable
- `Coordinate` — validación de rango ajustable
- `InitialGameState` — pantalla de configuración de partida

---

## 3. Lógica en Red (Proxy)

**Patrón introducido:** Proxy  
**Patrón que profundiza:** DIP, OCP, LogicType

### Descripción
Añadir `LogicType.NETWORK` que actúa como Proxy de `LocalGameLogic`. El resto del código (views, features) no cambia — el Proxy cumple la misma interfaz `Logic`.

### Diseño propuesto
```java
// LogicType enum
NETWORK {
    public Logic create() { return new RemoteGameLogic(); }
}

// Proxy
public class RemoteGameLogic implements Logic {
    private final LocalGameLogic local;          // delega localmente si no hay red
    private final GameClient client;             // conexión remota

    public OperationController getController() {
        return client.isConnected()
            ? client.fetchController()
            : local.getController();
    }
}
```

### Impacto
- Solo `LogicType` y `AppConfig` saben del nuevo tipo
- Ninguna vista ni feature cambia
- Demuestra OCP: abierto a extensión (nuevo tipo lógica), cerrado a modificación

---

## 4. Validación por Cadena (Chain of Responsibility) ✅

**Patrón introducido:** Chain of Responsibility  
**Patrón que profundiza:** Visitor (ErrorReport existente)

### Estado actual
Implementado en `controllers/features/game/validation/`: `CoordinateValidator` (interfaz) + `AbstractCoordinateValidator` (Template Method: `validate()` corre `check()` propio y delega en `next` si no hay error). Eslabones reales: `OccupiedValidator`, `OwnPieceValidator`, `RepeatedCoordinateValidator` — no existe un `BoundsValidator` como se proponía abajo (el rango de la coordenada se garantiza antes de construirla, no por la cadena). Compuesta en `LocalPlacementControllerBuilder.buildPlacementController(...)`:
```java
CoordinateValidator putTargetChain = new OccupiedValidator();
CoordinateValidator moveTargetChain = new OccupiedValidator();
moveTargetChain.setNext(new RepeatedCoordinateValidator());
CoordinateValidator moveOriginChain = new OwnPieceValidator();
```

### Descripción
Reemplazar/complementar el sistema de `ErrorReport` con una cadena de validadores que se compone en el builder. Cada validador se encarga de una sola regla.

### Diseño original propuesto (referencia histórica, no coincide 1:1 con lo implementado)
```java
// Nueva interfaz en controllers/features/game/
interface CoordinateValidator {
    ErrorReport validate(Coordinate coordinate, Game game);
    void setNext(CoordinateValidator next);
}

// Eslabones
class BoundsValidator implements CoordinateValidator { ... }
class OccupiedValidator implements CoordinateValidator { ... }
class OwnPieceValidator implements CoordinateValidator { ... }
```

Composición en `LocalPlacementControllerBuilder`:
```java
CoordinateValidator chain = new BoundsValidator(
    new OccupiedValidator(
        new OwnPieceValidator(null)));
```

### Impacto
- `LocalPutController` y `LocalMoveController` — usan la cadena en lugar de código inline
- `LocalPlacementControllerBuilder` — construye y compone la cadena
- Los `ErrorReport` existentes se reutilizan como resultados

---

## 5. Vista Decorada (Decorator) ✅

**Patrón introducido:** Decorator  
**Patrón que profundiza:** Visitor, views layer

### Estado actual
Implementado en `views/console/features/game/decorator/`: `ViewDecorator` (abstracto, envuelve un `GameView`) con `DebugView`, `TimestampedView`, `TurnNumberedView` como decoradores concretos. Se componen en `ViewType.createGameView()` (no en `GameFeature` como se proponía). Ver `docs/4+1views/logica/patrones/patron-decorator.puml` para el árbol completo, incluyendo el segundo árbol de Decorator del proyecto (`TimedPlacementController`, feature 8 más abajo).

### Descripción
Añadir decoradores sobre `ConsoleView` que enriquecen la presentación sin tocar la lógica. Se componen libremente en `GameFeature`.

### Decoradores propuestos (referencia histórica — nombres de clase coinciden, punto de composición no)
```java
// Decorador base
abstract class ViewDecorator implements View {
    protected final View wrapped;
    ViewDecorator(View wrapped) { this.wrapped = wrapped; }
}

// Muestra número de turno sobre el tablero
class TurnNumberedView extends ViewDecorator { ... }

// Añade timestamp a cada acción
class TimestampedView extends ViewDecorator { ... }

// Muestra estado interno para depuración
class DebugView extends ViewDecorator { ... }
```

### Composición en GameFeature
```java
View gameView = new TimestampedView(
    new TurnNumberedView(
        AppConfig.viewType().create()));
```

### Impacto
- Ninguna clase existente cambia (salvo `GameFeature`)
- Nuevas clases solo en `views/console/features/game/`
- Demuestra OCP de forma muy clara: nueva funcionalidad sin modificar clases

---

## 6. Perfiles de Jugador ✅

**Patrón que profundiza:** Singleton (ProfileRegistry), DAO  
**Patrón nuevo:** DAO (Data Access Object)

### Estado actual
Implementado en `models/features/player/` (`PlayerProfile`, `ProfileRegistry` Singleton), `controllers/features/player/` (`ProfileController`/`LocalProfileController`), `views/console/features/player/ConsoleProfileView.java`, `core/features/ProfileFeature.java`, `views/console/core/commands/ProfileCommand.java`. Se integra con la persistencia real (feature 10 más abajo), no con almacenamiento en memoria puro como sugería el diseño original.

### Descripción
Nombre personalizado, color preferido y estadísticas por jugador. Un `ProfileRegistry` (Singleton) gestiona los perfiles en memoria. Se integra con `StatisticsFeature`.

### Diseño original propuesto (referencia histórica)
```java
// models/features/player/
public class PlayerProfile {
    private final String name;
    private final Player token;    // OS o XS
    private int wins;
    private int gamesPlayed;
}

public class ProfileRegistry {
    private static ProfileRegistry instance;
    private final List<PlayerProfile> profiles;

    public static ProfileRegistry getInstance() { ... }
    public void register(PlayerProfile profile) { ... }
    public List<PlayerProfile> all() { ... }
}
```

### Nuevas features necesarias
```
core/features/ProfileFeature.java          — gestionar perfiles
controllers/features/player/               — interfaces del contrato
views/console/features/player/             — vista de perfiles
views/console/core/commands/ProfileCommand.java
```

### Integración con Statistics
`LocalStatisticsController` accede a `ProfileRegistry` para mostrar estadísticas con nombre en lugar de "OS" / "XS".

---

## 7. Logros ✅

**Patrón principal:** Observer, vía Event Bus (no un patrón nuevo — consumidor del `EventManager` existente)

### Descripción
Tres logros (`FIRST_WIN`, `WIN_STREAK_3`, `VETERAN_10_GAMES`, enum `Achievement`) que se desbloquean según el historial de partidas. `AchievementTracker` se suscribe a `GameEndedEvent` vía `EventWiring` — no hay llamada directa desde `Partida`.

### Archivos
```
models/features/achievements/Achievement.java
models/features/achievements/AchievementTracker.java
controllers/features/achievements/{AchievementsController,local/LocalAchievementsController}.java
core/features/AchievementsFeature.java
views/console/features/achievements/ConsoleAchievementsView.java
views/console/core/commands/ShowAchievementsCommand.java
```

Ver `docs/4+1views/logica/patrones/patron-observer-y-eventos.puml` para el diagrama.

---

## 8. Reloj por Turno ✅

**Patrón principal:** Decorator (sobre `PlacementController`, no sobre `GameView`)

### Descripción
Límite de 15s por turno en fase Put. `TimedPlacementController` (extiende `ForwardingPlacementController`) envuelve al `PutController` real; si `Instant.now()` supera el deadline al llamar `put()`, sustituye la coordenada elegida por una aleatoria válida. Sin hilos: el chequeo es síncrono, no hay interrupción real de la espera de consola.

### Archivos
```
controllers/features/game/local/TimedPlacementController.java
controllers/features/game/local/logic/TimedControllerFactory.java
```

Ver `docs/4+1views/logica/patrones/patron-decorator.puml`.

---

## 9. IA con Dificultad (EASY/HARD) ✅

**Patrón principal:** Strategy — corrige el mapa de patrones original, que marcaba Strategy como pendiente

### Descripción
Al iniciar una partida 1 jugador, `StartView` pregunta la dificultad (`AiDifficulty` enum: EASY/HARD). Cada constante implementa `createStrategy(): AiStrategy` (sin `if`/`switch` en el cliente). `RandomAiStrategy` elige uniformemente entre coordenadas válidas; `MinimaxAiStrategy` usa minimax completo en la fase Put y una heurística de una jugada en la fase de deslizamiento (el minimax sin cota no termina ahí, el número de fichas es constante). `LocalAiCoordinateController` (implementa `MachineCoordinateController`) compone el `AiStrategy` elegido.

### Archivos
```
controllers/features/game/local/ai/{AiDifficulty,AiStrategy,RandomAiStrategy,MinimaxAiStrategy}.java
controllers/features/game/local/LocalAiCoordinateController.java
controllers/features/game/MachineCoordinateController.java
```

Ver `docs/4+1views/logica/patrones/patron-strategy-ia.puml`.

---

## 10. Persistencia Real (File/JSON/SQLite) ✅

**Patrón principal:** DAO + Abstract Factory  
**Patrón que profundiza:** Strategy (codecs), Template Method

### Descripción
Reemplaza el `GameRegistry`/`Statistics` en memoria original. `PersistenceType` (IN_MEMORY/FILE/JSON/SQLITE) crea el `DaoFactory` correspondiente (Abstract Factory: una familia consistente de `GameDao`+`StatisticsDao` por tecnología). Rama File/Json comparte `AbstractFileDao`+`FileCodec` (Strategy: `GsonCodec` vs `ObjectStreamCodec`) vía `AbstractGameFileDao`/`AbstractStatisticsFileDao` (Template Method). Rama Sqlite usa `SqliteSupport` para centralizar conexión/transacción. Encima, `GameSnapshotService`/`StatisticsService` son la fachada que consumen las features.

### Archivos
```
models/persistence/{Persistence,PersistenceType}.java
models/persistence/repository/factory/{DaoFactory,FileDaoFactory,JsonDaoFactory,SqliteDaoFactory,InMemoryDaoFactory}.java
models/persistence/repository/dao/  (GameDao, StatisticsDao, AbstractFileDao, FileCodec, GsonCodec,
                                      ObjectStreamCodec, AbstractGameFileDao, AbstractStatisticsFileDao,
                                      File/Json/SqliteGameDao, File/Json/SqliteStatisticsDao, SqliteSupport)
models/persistence/service/{GameSnapshotService,StatisticsService}.java
```

Ver `docs/4+1views/logica/patrones/patron-dao-persistencia.puml`.

---

## Mapa de patrones

```
Patrones ya implementados:
  ✅ Visitor (doble despacho)
  ✅ State Machine
  ✅ Observer                  ← también Feature 7 (Logros) vía Event Bus
  ✅ Memento (Undo/Redo)
  ✅ Builder
  ✅ Command + Menu
  ✅ Null Object (NullCoordinate)
  ✅ Singleton
  ✅ Iterator                  ← Feature 1 (Replay)
  ✅ Chain of Responsibility   ← Feature 4 (Validación)
  ✅ Decorator                 ← Feature 5 (Vista) y Feature 8 (Reloj por turno)
  ✅ DAO                       ← Feature 6 (Perfiles) y Feature 10 (Persistencia)
  ✅ Strategy                  ← Feature 9 (IA) — no la Feature 2 (tablero variable), que sigue pendiente
  ✅ Abstract Factory          ← Feature 10 (Persistencia, DaoFactory)

Patrones por implementar:
  ⬜ Strategy más completo (WinCondition)  ← Feature 2 (Tablero variable, sigue pendiente)
  ⬜ Proxy     ← Feature 3 (Red)
```

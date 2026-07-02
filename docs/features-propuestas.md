# Features Propuestas — TicTacToe Java

Catálogo de features educativas para ampliar el proyecto. Cada una introduce un patrón de diseño nuevo o profundiza en los existentes.

---

## Estado

| # | Feature | Patrón principal | Estado |
|---|---------|-----------------|--------|
| 1 | Replay de partida | Iterator | ✅ Implementada |
| 2 | Modo de tablero variable | Strategy | ⬜ Pendiente |
| 3 | Lógica en red | Proxy | ⬜ Pendiente |
| 4 | Validación por cadena | Chain of Responsibility | ⬜ Pendiente |
| 5 | Vista decorada | Decorator | ⬜ Pendiente |
| 6 | Perfiles de jugador | Singleton + DAO | ⬜ Pendiente |

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

## 4. Validación por Cadena (Chain of Responsibility)

**Patrón introducido:** Chain of Responsibility  
**Patrón que profundiza:** Visitor (ErrorReport existente)

### Descripción
Reemplazar/complementar el sistema de `ErrorReport` con una cadena de validadores que se compone en el builder. Cada validador se encarga de una sola regla.

### Diseño propuesto
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

## 5. Vista Decorada (Decorator)

**Patrón introducido:** Decorator  
**Patrón que profundiza:** Visitor, views layer

### Descripción
Añadir decoradores sobre `ConsoleView` que enriquecen la presentación sin tocar la lógica. Se componen libremente en `GameFeature`.

### Decoradores propuestos
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

## 6. Perfiles de Jugador

**Patrón que profundiza:** Singleton (ProfileRegistry), DAO  
**Patrón nuevo:** DAO (Data Access Object)

### Descripción
Nombre personalizado, color preferido y estadísticas por jugador. Un `ProfileRegistry` (Singleton) gestiona los perfiles en memoria. Se integra con `StatisticsFeature`.

### Diseño propuesto
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

## Mapa de patrones

```
Patrones ya implementados:
  ✅ Visitor (doble despacho)
  ✅ State Machine
  ✅ Observer
  ✅ Memento (Undo/Redo)
  ✅ Builder
  ✅ Command + Menu
  ✅ Null Object (NullCoordinate)
  ✅ Singleton
  ✅ Iterator  ← Feature 1 (Replay)

Patrones por implementar:
  ⬜ Strategy  ← Feature 2 (Tablero variable)
  ⬜ Proxy     ← Feature 3 (Red)
  ⬜ Chain of Responsibility  ← Feature 4
  ⬜ Decorator  ← Feature 5
  ⬜ DAO        ← Feature 6
```

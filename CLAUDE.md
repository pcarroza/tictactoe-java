# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
./gradlew run          # run the app (requires interactive stdin)
./gradlew build        # compile + test
./gradlew test         # run all tests
./gradlew test --tests "main.models.features.game.BoardTest"  # run a single test class
```

Java 17+, JUnit 4.13.1. Main class: `com.citadel.tictactoe.core.TicTacToeApp`.

---

## Layer Architecture (strict DAG — no cycles)

```
libs / events  ← no dependencies (base utilities)
models         ← libs
controllers    ← models, libs, events
views          ← controllers, models, libs, events
core           ← everything (composition root only)
```

**Hard rule:** `models/`, `controllers/`, and `views/` must never import from `main.core.*`. Features never import each other — they communicate only via `EventManager.publish/subscribe` or `AppManager.navigateTo()`.

Each layer has its own `core/` sub-package for intra-layer contracts shared between features. Feature packages (`features/game/`, `features/load/`, etc.) never cross-import.

---

## Key Patterns

**Double Dispatch (Visitor)** — the central dispatch mechanism between controllers and views. A `View.interact(controller)` calls `controller.accept(this)`, which calls back `view.visit(concreteController)`. Adding a new controller type requires: new interface, new `visit()` overload in the visitor interface, and implementation in every concrete visitor. `instanceof` and `switch` by type are prohibited everywhere.

**State Machine** — `LocalGameLogic` drives the game loop. States (`InitialGameState`, `InGameState`, `SaveMenuState`, `EndGameState`, `ExitGameState`) are built by `GameStatesBuilder` and held in `LocalGameLogic`. Each state returns a controller via `getController()`; `ExitGameState` returns `null` to end the loop. Transitions fire via `Observer`: `Board extends Subject` notifies `LocalGameLogic implements Observer` on every board mutation. `GameState` base class has `save()`/`resume()` that `assert false` by default — only states that support the transition override them.

**Observer** — `Subject` + `Observer` are in `models/`. `Observer` declares `update()`, `save()`, and `resume()`. `Board` is the subject; `LocalGameLogic` is the observer.

**Command + Menu chrome** — `Command` (abstract) has a no-op `set(Feature)` and abstract `execute()`. Only commands that need a feature override `set()`. `Menu.set(feature)` distributes to all commands uniformly. `MainMenu` is the top-level chrome containing a `GameMenu` sub-menu and `LoadGameCommand`.

**AppConfig** — `TicTacToeApp` sets `LogicType` and `ViewType` once; every feature reads them. Adding a new logic or view implementation means adding one enum constant, not touching features.

---

## Game Flow

```
TicTacToeApp → AppConfig.set(LOCAL, CONSOLE)
             → MainMenu
                 → StartGameCommand → GameFeature.run()
                 → LoadGameCommand  → LoadFeature.run() → GameFeature(snapshot).run()

GameFeature.run():
  do {
    controller = logic.getController()   // current state decides controller type
    view.interact(controller)            // double dispatch
  } while (controller != null)          // ExitGameState returns null
```

State transitions with Save:

```
InGameState --[save()]--> SaveMenuState --[resume()]--> InGameState
                                        --[exit()]---> ExitGameState
```

---

## Code Style (enforced)

- **`assert` for contracts** (preconditions, invariants, postconditions). Never for user input or external resources — use exceptions there.
- **No `instanceof` or `switch` by type** — use Visitor / polymorphism.
- **Blank line between every field and between every method**.
- **Minimum visibility**: package-private by default; `public` only when the class is part of a layer's API.
- **Method size**: ≤ 15 LOC, ≤ 3 parameters, ≤ 2 nesting levels.
- **Class size**: ≤ 5 fields, ≤ 20 methods, ≤ 500 LOC.
- **CBO ≤ 5** (coupling between objects — number of classes a class depends on).
- No comments unless the *why* is non-obvious. Names document the *what*.

---

## Persistence (in-memory)

`GameRegistry` (singleton) stores `GameSnapshot` objects. A `GameSnapshot` captures `Map<Player, Set<Coordinate>>`, `currentPlayerIndex`, and `numUsers`. `LocalGameLogic` has two constructors: no-arg (new game, starts at `InitialGameState`) and `(GameSnapshot)` (restored game, starts at `InGameState`).

---

## Adding a New Feature

1. `controllers/features/<name>/` — interfaces + `local/` implementation
2. `views/console/features/<name>/` — concrete views
3. `core/features/<Name>Feature.java` — implements `Feature`, reads `AppConfig`
4. `views/console/core/commands/Start<Name>Command.java` — extends `Command`
5. Wire the command into `MainMenu` (or a sub-menu)

Features in `controllers/` expose only interfaces. `core/` wires the concrete implementations.

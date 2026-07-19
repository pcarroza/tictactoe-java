# Graph Report - .  (2026-07-17)

## Corpus Check
- 298 files · ~68,120 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 2219 nodes · 5201 edges · 126 communities (103 shown, 23 thin omitted)
- Extraction: 87% EXTRACTED · 13% INFERRED · 0% AMBIGUOUS · INFERRED: 667 edges (avg confidence: 0.81)
- Token cost: 0 input · 508,554 output

## Community Hubs (Navigation)
- Community 0
- Community 1
- Community 2
- Community 3
- Community 4
- Community 5
- Community 6
- Community 7
- Community 8
- Community 9
- Community 10
- Community 11
- Community 12
- Community 13
- Community 14
- Community 15
- Community 16
- Community 17
- Community 18
- Community 19
- Community 20
- Community 21
- Community 22
- Community 23
- Community 24
- Community 25
- Community 26
- Community 27
- Community 28
- Community 29
- Community 30
- Community 31
- Community 32
- Community 33
- Community 34
- Community 35
- Community 36
- Community 37
- Community 38
- Community 39
- Community 40
- Community 41
- Community 42
- Community 43
- Community 44
- Community 45
- Community 46
- Community 47
- Community 48
- Community 49
- Community 50
- Community 51
- Community 52
- Community 53
- Community 54
- Community 55
- Community 56
- Community 57
- Community 58
- Community 59
- Community 60
- Community 61
- Community 62
- Community 63
- Community 64
- Community 65
- Community 66
- Community 67
- Community 68
- Community 69
- Community 70
- Community 71
- Community 72
- Community 73
- Community 74
- Community 75
- Community 76
- Community 77
- Community 78
- Community 79
- Community 80
- Community 81
- Community 82
- Community 83
- Community 84
- Community 85
- Community 86
- Community 87
- Community 88
- Community 89
- Community 90
- Community 91
- Community 92
- Community 93
- Community 94
- Community 95
- Community 96
- Community 97
- Community 98
- Community 99
- Community 100
- Community 101
- Community 102
- Community 103
- Community 104
- Community 105
- Community 106
- Community 107
- Community 108
- Community 109
- Community 110
- Community 111
- Community 112
- Community 113
- Community 114
- Community 116
- Community 117
- Community 118
- Community 119
- Community 120
- Community 121
- Community 122

## God Nodes (most connected - your core abstractions)
1. `Coordinate` - 224 edges
2. `Game` - 110 edges
3. `Player` - 109 edges
4. `GameSnapshot` - 62 edges
5. `Board` - 60 edges
6. `MoveHistory` - 53 edges
7. `ErrorReport` - 49 edges
8. `PlacementController` - 42 edges
9. `BoardBuilder` - 42 edges
10. `LimitedIntDialog` - 39 edges

## Surprising Connections (you probably didn't know these)
- `diagrama-estados-repeticion.puml` --references--> `ReplayStatesBuilder`  [EXTRACTED]
  docs/4+1views/logica/README.md → src/main/java/com/citadel/tictactoe/controllers/features/replay/local/logic/ReplayStatesBuilder.java
- `Feature 9: IA con Dificultad EASY/HARD (Strategy)` --references--> `LocalAiCoordinateController`  [EXTRACTED]
  docs/features-propuestas.md → src/main/java/com/citadel/tictactoe/controllers/features/game/local/LocalAiCoordinateController.java
- `patron-decorator.puml` --references--> `TimedPlacementController`  [EXTRACTED]
  docs/4+1views/logica/README.md → src/main/java/com/citadel/tictactoe/controllers/features/game/local/TimedPlacementController.java
- `hilo-unico.puml` --references--> `TimedPlacementController`  [EXTRACTED]
  docs/4+1views/procesos/README.md → src/main/java/com/citadel/tictactoe/controllers/features/game/local/TimedPlacementController.java
- `Feature 8: Reloj por Turno (Decorator)` --references--> `TimedPlacementController`  [EXTRACTED]
  docs/features-propuestas.md → src/main/java/com/citadel/tictactoe/controllers/features/game/local/TimedPlacementController.java

## Import Cycles
- None detected.

## Hyperedges (group relationships)
- **Patrones GoF de comportamiento activamente usados en TicTacToe Java** — agents_design_design_patterns_catalog_state, agents_design_design_patterns_catalog_visitor, agents_design_design_patterns_catalog_command, agents_design_design_patterns_catalog_observer, agents_design_design_patterns_catalog_strategy, agents_design_design_patterns_catalog_template_method [INFERRED 0.85]
- **Los cinco principios SOLID** — agents_design_solid_principles_srp, agents_design_solid_principles_ocp, agents_design_solid_principles_lsp, agents_design_solid_principles_isp, agents_design_solid_principles_dip [EXTRACTED 1.00]
- **Piezas del modelo FSP (Feature-Service-Panel) en CitadelPanel** — agents_design_architecture_views_app_composition_root, agents_design_architecture_views_panel_ui_pura, agents_design_architecture_views_service_business_logic, agents_design_architecture_views_state_objects, agents_design_architecture_views_core_shell_chrome, agents_design_architecture_views_builder_declarative_config [EXTRACTED 1.00]
- **UIConfig Scaling Parameters (Scale/Density/Theme/Animations)** — agents_design_ui_context_user_guide_ui_scale, agents_design_ui_context_user_guide_ui_density, agents_design_ui_context_user_guide_theme, agents_design_ui_context_user_guide_animations, agents_design_ui_context_developer_guide_uiconfig [INFERRED 0.90]
- **Three-Chain Visitor Double-Dispatch Flow** — agents_design_visitor_pattern_operationcontrollervisitor, agents_design_visitor_pattern_placementcontrollervisitor, agents_design_visitor_pattern_coordinatecontrollervisitor, agents_design_visitor_pattern_visitor_pattern [EXTRACTED 1.00]
- **FSP Panel/Service/App Roles with Internal/External Events** — agents_steering_architecture_fsp_panel_role, agents_steering_architecture_fsp_service_role, agents_steering_architecture_fsp_app_role, agents_steering_architecture_fsp_internal_events, agents_steering_architecture_fsp_external_events [EXTRACTED 1.00]
- **4+1 Architectural Views Documentation Set** — docs_4_1views_desarrollo_readme_vistadesarrollo, docs_4_1views_escenarios_readme_vistaescenarios, docs_4_1views_fisica_readme_vistafisica, docs_4_1views_logica_readme_vistalogica, docs_4_1views_procesos_readme_vistaprocesos [EXTRACTED 1.00]
- **Real Persistence Stack (DAO + Abstract Factory + Template Method)** — persistencetype_persistencetype, daofactory_daofactory, sqlitesupport_sqlitesupport, gamesnapshotservice_gamesnapshotservice, statisticsservice_statisticsservice [INFERRED 0.85]
- **State Machine Core Classes (Initial/InGame/Save/End/Exit)** — localgamelogic_localgamelogic, gamestatesbuilder_gamestatesbuilder, initialgamestate_initialgamestate, ingamestate_ingamestate, savemenustate_savemenustate, endgamestate_endgamestate, exitgamestate_exitgamestate [EXTRACTED 1.00]

## Communities (126 total, 23 thin omitted)

### Community 0 - "Community 0"
Cohesion: 0.05
Nodes (21): persistencia.puml, secuencia-persistencia.puml, LoadController, LoadControllerVisitor, Override, LocalLoadController, ProfileController, createGameView() (+13 more)

### Community 1 - "Community 1"
Cohesion: 0.06
Nodes (19): CoordinateController, CoordinateControllerVisitor, LocalUserCoordinateController, MachineCoordinateController, UserCoordinateController, LimitedIntDialog, CoordinateView, Override (+11 more)

### Community 2 - "Community 2"
Cohesion: 0.07
Nodes (16): repeticion.puml, secuencia-repeticion.puml, Override, LocalSelectReplayController, SelectReplayController, SelectReplayControllerVisitor, createSelectReplayView(), Override (+8 more)

### Community 3 - "Community 3"
Cohesion: 0.07
Nodes (21): logros.puml, secuencia-logros.puml, Feature 7: Logros (Observer vía Event Bus), AchievementsController, Override, LocalAchievementsController, createAchievementsView(), AchievementsFeature (+13 more)

### Community 4 - "Community 4"
Cohesion: 0.09
Nodes (15): BoundsValidator (propuesto, no implementado), Feature 4: Validación por Cadena (Chain of Responsibility), getErrorReport(), LocalPlacementControllerBuilder, Override, LocalUserPlacementControllerBuilder, LocalCoordinateController, AbstractCoordinateValidator (+7 more)

### Community 5 - "Community 5"
Cohesion: 0.09
Nodes (5): FakeMoveController, FakePutController, Override, Test, TimedControllerFactoryTest

### Community 6 - "Community 6"
Cohesion: 0.11
Nodes (4): ForwardingPlacementController, Override, PlacementController, Override

### Community 7 - "Community 7"
Cohesion: 0.09
Nodes (12): ErrorReport, ErrorReportVisitor, Override, NotEmptyErrorReport, Override, NotPropertyErrorReport, Override, RepeatedCoordinateErrorReport (+4 more)

### Community 8 - "Community 8"
Cohesion: 0.09
Nodes (6): Observer Pattern (Subject/Observer, Board/LocalGameLogic), patron-observer-y-eventos.puml, Observer, Subject, Override, NoOpObserver

### Community 9 - "Community 9"
Cohesion: 0.13
Nodes (11): Override, MoveHistory, MoveRecord, MoveType, PUT, REMOVE, HistoryView, Coordinate (+3 more)

### Community 10 - "Community 10"
Cohesion: 0.11
Nodes (11): Override, LoadGameCommand, Override, ProfileCommand, Override, ReplayGameCommand, Override, ShowAchievementsCommand (+3 more)

### Community 11 - "Community 11"
Cohesion: 0.12
Nodes (11): BorderPane, Button, GridPane, Parent, PresenterController, Player, NONE, OS (+3 more)

### Community 12 - "Community 12"
Cohesion: 0.16
Nodes (9): Entry, PreparedStatement, ResultSet, GameSnapshotEntity, MoveRecordEntity, GameRow, Connection, Override (+1 more)

### Community 13 - "Community 13"
Cohesion: 0.12
Nodes (30): DesignProvider (Singleton), DesignTokens (Static), UI Context Developer Guide, Migration Guide Workflow, ScaleCalculator (Static), UIConfig (Immutable Config), Enable Animations toggle, UI Context User Guide (+22 more)

### Community 14 - "Community 14"
Cohesion: 0.14
Nodes (8): GameSnapshot, GameDao, InMemoryGameDao, Override, GameSnapshotService, InMemoryGameDaoTest, Before, Test

### Community 15 - "Community 15"
Cohesion: 0.11
Nodes (3): Override, LocalReplayController, LocalReplayLogic

### Community 16 - "Community 16"
Cohesion: 0.12
Nodes (3): Board, Coordinate, Override

### Community 17 - "Community 17"
Cohesion: 0.11
Nodes (14): createDaoFactory(), Override, PersistenceType, FILE, IN_MEMORY, JSON, SQLITE, DaoFactory (+6 more)

### Community 18 - "Community 18"
Cohesion: 0.10
Nodes (28): Abstract Factory pattern, Adapter pattern, Builder pattern, Chain of Responsibility pattern, Command pattern, Composite pattern, Decorator pattern, Design Patterns Catalog - Quick Reference (+20 more)

### Community 19 - "Community 19"
Cohesion: 0.12
Nodes (4): GameState, InGameState, Override, Override

### Community 20 - "Community 20"
Cohesion: 0.15
Nodes (9): EASY, HARD, Override, AiStrategy, Override, LocalAiCoordinateController, Coordinate, Test (+1 more)

### Community 21 - "Community 21"
Cohesion: 0.15
Nodes (8): Override, LocalGamePutController, Override, Override, TimedControllerFactory, Override, OperationControllerVisitor, PlacementControllerVisitor

### Community 22 - "Community 22"
Cohesion: 0.12
Nodes (10): State Transitions with Save, State Machine (LocalGameLogic drives game loop), diagrama-estados-partida.puml, patron-estado.puml, ExitGameState, GameStatesBuilder, InitialGameState, Override (+2 more)

### Community 23 - "Community 23"
Cohesion: 0.14
Nodes (6): ReplayController, getInstance(), Terminal, INSTANCE, ConsoleReplayView, Override

### Community 24 - "Community 24"
Cohesion: 0.12
Nodes (9): Coordinate, Override, NullCoordinate, Direction, DIAGONAL, HORIZONTAL, INVERSE, NON_EXISTENT (+1 more)

### Community 25 - "Community 25"
Cohesion: 0.09
Nodes (25): Antipatrones y Code Smells, Clases Alternativas con Interfaces Diferentes, AntiPatterns (Brown, Malveau, McCormick, Mowbray), Clase de Datos (Data Class), Grupo de Datos (Data Clumps), Código Muerto / Lava Flow, Cambios Divergentes (Divergent Change), Descomposición Funcional (Functional Decomposition) (+17 more)

### Community 26 - "Community 26"
Cohesion: 0.13
Nodes (11): patron-strategy-ia.puml, Feature 9: IA con Dificultad EASY/HARD (Strategy), Label, AiDifficulty, createStrategy(), Override, LocalAiPlacementControllerBuilder, StartController (+3 more)

### Community 27 - "Community 27"
Cohesion: 0.15
Nodes (6): Override, RandomAiStrategy, Coordinate, Override, Override, Coordinate

### Community 28 - "Community 28"
Cohesion: 0.15
Nodes (5): ReplayState, ReplayStatesBuilder, Override, ShowMoveReplayState, ReplayBoard

### Community 29 - "Community 29"
Cohesion: 0.10
Nodes (24): Cita a 05-pattern-gates (Context Object como alternativa a Singleton), Catálogo de Patrones de Diseño — Guía Profunda, Adapter (Adaptador), Composite (Composición estructural), Design Patterns (Gang of Four), Null Object, Observer (Observador), Gate obligatorio para Singleton (steering/05-pattern-gates.md) (+16 more)

### Community 30 - "Community 30"
Cohesion: 0.14
Nodes (12): Application, AppConfig Pattern, Game Flow, AppConfig, LogicType, ViewType, GameFeature, Override (+4 more)

### Community 31 - "Community 31"
Cohesion: 0.12
Nodes (8): GameOperationController, Override, Override, Override, Override, Override, Stage, JavaFxGameView

### Community 32 - "Community 32"
Cohesion: 0.16
Nodes (4): LocalOperationControllerBuilder, Override, LocalGameSaveController, LocalGameStartController

### Community 33 - "Community 33"
Cohesion: 0.27
Nodes (3): BoardBuilder, DirectionsOfColorBoardTest, Test

### Community 34 - "Community 34"
Cohesion: 0.13
Nodes (22): GRASP: Controller, GRASP: Creator, SOLID: Dependency Inversion Principle, OO Principles - Quick Reference, GRASP: Information Expert, GRASP: Indirection, SOLID: Interface Segregation Principle, SOLID: Liskov Substitution Principle (+14 more)

### Community 36 - "Community 36"
Cohesion: 0.13
Nodes (7): ClosedInterval, Override, ClosedIntervalView, Override, ClosedIntervalBuilder, Override, IntervalBuilder

### Community 37 - "Community 37"
Cohesion: 0.15
Nodes (5): Command, ExitCommand, Override, Override, Menu

### Community 38 - "Community 38"
Cohesion: 0.17
Nodes (10): patron-decorator.puml, Feature 5: Vista Decorada (Decorator), createLoadView(), createProfileView(), createReplayView(), DebugView, TimestampedView, TurnNumberedView (+2 more)

### Community 39 - "Community 39"
Cohesion: 0.12
Nodes (6): LocalGameOperationController, Override, Override, RedoMenuState, Override, UndoMenuState

### Community 40 - "Community 40"
Cohesion: 0.19
Nodes (5): StatisticsDao, StatisticsService, Before, Test, StatisticsServiceTest

### Community 41 - "Community 41"
Cohesion: 0.10
Nodes (11): ErrorGeneratorType, NOT_EMPTY, NOT_PROPERTY, REPEATED_COORDINATE, ErrorReportGenerator, Override, NotEmptyErrorReportGenerator, Override (+3 more)

### Community 42 - "Community 42"
Cohesion: 0.23
Nodes (4): Coordinate, Override, MinimaxAiStrategy, Search

### Community 43 - "Community 43"
Cohesion: 0.15
Nodes (4): Override, LocalGamePlacementController, Override, LocalGameRedoController

### Community 44 - "Community 44"
Cohesion: 0.17
Nodes (7): estadisticas.puml, secuencia-estadisticas.puml, Override, LocalStatisticsController, Override, StatisticsFeature, Statistics

### Community 45 - "Community 45"
Cohesion: 0.23
Nodes (4): Turn, Before, Test, TurnTest

### Community 47 - "Community 47"
Cohesion: 0.13
Nodes (18): Arquitectura del Composition Root (core/), core/config/ (AppConfig, LogicType, ViewType), core/contracts/ (Runner), core/features/ (XxxFeature, ortogonal), core/lifecycle/ (ConsoleRunner, JavaFxRunner, RunnerFactory), core/platform/ (JavaFxTicTacToeApp), Abstract Factory (Fábrica Abstracta), Integración de JavaFX — TicTacToe Java (+10 more)

### Community 48 - "Community 48"
Cohesion: 0.20
Nodes (9): despliegue.puml, SQLite Embedded, Single JVM Process Rationale, Vista Física, FunctionalInterface, Connection, SQLException, SqlAction, SqlFunction (+1 more)

### Community 49 - "Community 49"
Cohesion: 0.14
Nodes (5): GameView, BoardView, ConsoleGameView, SaveView, StartView

### Community 50 - "Community 50"
Cohesion: 0.18
Nodes (6): FileGameDaoTest, TemporaryFolder, Test, TemporaryFolder, Test, JsonGameDaoTest

### Community 51 - "Community 51"
Cohesion: 0.20
Nodes (7): other(), Connection, Override, SqliteStatisticsDao, TemporaryFolder, Test, SqliteStatisticsDaoTest

### Community 52 - "Community 52"
Cohesion: 0.15
Nodes (17): Adding a New Feature (Guide), Persistence (In-Memory) — GameRegistry/GameSnapshot, Partida Remota (Propuesta Descartada por Complejidad), patron-dao-persistencia.puml, hilo-unico.puml, Single-Thread, Blocking I/O Design Rationale, Vista de Procesos, Catálogo de Features Educativas Propuestas (+9 more)

### Community 53 - "Community 53"
Cohesion: 0.22
Nodes (6): TimedPlacementController, PutController, CapturingVisitor, Coordinate, Test, TimedPlacementControllerTest

### Community 56 - "Community 56"
Cohesion: 0.21
Nodes (3): GameRegistryTest, Before, Test

### Community 57 - "Community 57"
Cohesion: 0.24
Nodes (7): StatisticsDto, AbstractStatisticsFileDao, Override, InMemoryStatisticsDao, Override, InMemoryStatisticsDaoTest, Test

### Community 58 - "Community 58"
Cohesion: 0.14
Nodes (7): FileGameDao, FileStatisticsDao, Override, SuppressWarnings, ObjectStreamCodec, FileDaoFactory, Override

### Community 59 - "Community 59"
Cohesion: 0.21
Nodes (16): AppBootstrap (Composition Root), ConsoleView (console Panel), Views Architecture (FSP for Java), EventManager / EventBus, FSP Pattern adapted to Java, GraphicsHomeMenu, GraphicsView (JavaFX Panel), HomeMenuOption (enum) (+8 more)

### Community 60 - "Community 60"
Cohesion: 0.17
Nodes (15): Envidia de Características (Feature Envy), Tamaño y responsabilidad de clases (SRP), Diseño de Dependencias, Inyección de Dependencias (DI), Principio de Inversión de Dependencias (DIP), Inapropiada Intimidad (Inappropriate Intimacy), Inversión de Control (IoC), Principio Abierto/Cerrado (OCP) (+7 more)

### Community 61 - "Community 61"
Cohesion: 0.14
Nodes (15): Diseño por Contrato, Aserciones vs Programación Defensiva, Design by Contract (Bertrand Meyer), Invariante de Clase {I}, Herencia y contratos (LSP), Postcondición {Q}, Precondición {P}, State (Estado) (+7 more)

### Community 62 - "Community 62"
Cohesion: 0.18
Nodes (4): Override, LocalGameContinueController, EndGameState, Override

### Community 63 - "Community 63"
Cohesion: 0.25
Nodes (5): Override, PlayerProfile, Before, Test, ProfileRegistryTest

### Community 64 - "Community 64"
Cohesion: 0.21
Nodes (5): StatisticsController, createStatisticsView(), ConsoleStatisticsView, Override, StatisticsView

### Community 65 - "Community 65"
Cohesion: 0.14
Nodes (14): RunnerFactory (Map<ViewType,Runner>, sin switch/instanceof), Visitor (Doble Despacho), Guía para agregar una nueva feature — TicTacToe Java, Checklist de feature completa, Paso 2: Interfaces en controllers/features/X/, Paso 3: Implementación en controllers/features/X/local/, Paso 5: Coordinador en core/features/X/, Paso 7: Comando de menú en controllers/core/commands/ (+6 more)

### Community 66 - "Community 66"
Cohesion: 0.15
Nodes (14): YAGNI, Comments Policy, Clean Code - Immediate Application Rules, DRY Principle, Formatting Rules, Function Design Rules, KISS Principle, Naming Conventions (+6 more)

### Community 67 - "Community 67"
Cohesion: 0.24
Nodes (6): LocalGameLogic, Logic, create(), Override, LOCAL, GameRegistry

### Community 68 - "Community 68"
Cohesion: 0.27
Nodes (3): MoveController, GameView, Override

### Community 69 - "Community 69"
Cohesion: 0.18
Nodes (3): AbstractFileDao, FileCodec, FileSupport

### Community 70 - "Community 70"
Cohesion: 0.33
Nodes (13): CoordinateControllerVisitor, Visitor Pattern - Double Dispatch View<->Controller, GameContinueController, GameMoveController, GameSaveController (extension example), GameStartController, OperationControllerVisitor, PlacementController (+5 more)

### Community 71 - "Community 71"
Cohesion: 0.26
Nodes (13): GRASP: High Cohesion, GRASP: Low Coupling, CBO (Coupling Between Objects), Class Size Limits (LOC/attributes/methods), DIT (Depth of Inheritance Tree), Quality Metrics - Concrete Limits (generic), LCOM (Lack of Cohesion of Methods), Method Size Limits (params/LOC/CC/nesting) (+5 more)

### Community 72 - "Community 72"
Cohesion: 0.17
Nodes (13): Code Style (Enforced), Double Dispatch (Visitor), Layer Architecture (Strict DAG), componentes-build.puml, Naming Note: 'libs' (CLAUDE.md) vs 'shared' (physical package), Árbol de Paquetes (6 paquetes raíz), Vista de Desarrollo, diagrama-estados-repeticion.puml (+5 more)

### Community 75 - "Community 75"
Cohesion: 0.32
Nodes (3): ClosedIntervalTest, Before, Test

### Community 76 - "Community 76"
Cohesion: 0.18
Nodes (12): Eventos Internal/External por feature, core/launcher/ (TicTacToeApp, main()), Composition Root (quién crea las dependencias), Arquitectura para Aplicaciones de Escritorio OO, Composition Root — único punto de ensamblado, Comunicación entre módulos vía Event Bus, Inversión de Control en el Game Loop (Principio Hollywood), Arquitectura MVC por Capas (Vista/Controlador/Modelo) (+4 more)

### Community 77 - "Community 77"
Cohesion: 0.18
Nodes (12): AppBootstrap (Factory Method estático), AppContext (Context Object), core/bootstrap/ (AppContext, AppBootstrap, EventWiring), Paso 6: Registrar en AppBootstrap.load(), GRASP — Patrones Generales de Asignación de Responsabilidades, Controlador (Controller), GRASP (Craig Larman), Creador (Creator) (+4 more)

### Community 78 - "Community 78"
Cohesion: 0.20
Nodes (12): Regla de dependencia unidireccional (evitar ciclo config↔lifecycle↔platform), Capa de Persistencia (DAO), Principio de Dependencias Acíclicas (ADP), DAO — desacoplar persistencia (soluciones 12-13), Dependencias entre paquetes — TicTacToe Java, Principio base: ADP (Acyclical Dependencies Principle), controllers/core/commands/, Por qué events/ está en la raíz del grafo (+4 more)

### Community 79 - "Community 79"
Cohesion: 0.20
Nodes (6): Command + Menu Chrome, partida.puml, secuencia-partida.puml, Override, StartGameCommand, GameMenu

### Community 81 - "Community 81"
Cohesion: 0.29
Nodes (3): RedoController, Override, RedoView

### Community 82 - "Community 82"
Cohesion: 0.29
Nodes (3): UndoController, Override, UndoView

### Community 83 - "Community 83"
Cohesion: 0.18
Nodes (4): EventWiring, EventManager, SuppressWarnings, Listener

### Community 85 - "Community 85"
Cohesion: 0.26
Nodes (4): AbstractGameFileDao, Override, Type, JsonGameDao

### Community 86 - "Community 86"
Cohesion: 0.18
Nodes (11): Clase Grande (Large Class / BLOB), Command (Comando), Evolución de Arquitecturas MV* con Métricas, Camino de 13 pasos hacia MVP-PM limpio (Klondike), Command elimina switch-case en menú (solución 2), Facade (clase Logic) resuelve vista conociendo todos los controladores (solución 5), Métricas comparadas: LCOM, Factor de Acoplamiento, Complejidad Ciclomática, Proxy — desacoplar comunicación TCP/IP (soluciones 10-11) (+3 more)

### Community 87 - "Community 87"
Cohesion: 0.20
Nodes (11): CitadelPanel — Walkthrough de la Arquitectura de Views, ActionBarPanel (Shell), Anti-patrones con ejemplos de código real (4 casos), Builders (SymbolRowCardBuilder y similares), Cómo agregar OrderPanel (walkthrough de nueva feature), SearchBar, SlidePanel — contenedor compartido, SymbolList (CollectionState<SymbolRow>) (+3 more)

### Community 88 - "Community 88"
Cohesion: 0.31
Nodes (4): ContinueController, ContinueView, Stage, JavaFxContinueView

### Community 89 - "Community 89"
Cohesion: 0.20
Nodes (10): Arquitectura de Views — CitadelPanel, App — Composition Root (capa Core), Problema del Callback Hell y su eliminación, App.cs — Composition Root (código real), Core y chrome — host de la aplicación (Shell), Clasificación Feature / Sub-feature / Configuración (prueba de las 3 preguntas), Modelo FSP (Feature — Service — Panel), Contrato uniforme IFeatureCoordinator / IViewFeature (+2 more)

### Community 90 - "Community 90"
Cohesion: 0.20
Nodes (10): SymbolRow, Shared — design system del proyecto, Guía de Uso: Componentes Base Agnósticos, Mejores prácticas: variantes/tamaños predefinidos, composición, Card — Contenedor con Estilos, Input — Campo de Entrada, Label — Texto Estilizado, Migración PanelHeader (antes/después) (+2 more)

### Community 91 - "Community 91"
Cohesion: 0.20
Nodes (10): Strategy (Estrategia), Guía de Herencia en Diseño OO, Doble Despacho (Visitor aplicado a herencia), Herencia vs Composición, Regla ISA (is-a) para herencia, ISP en herencia (interfaces cohesivas), LSP aplicado a herencia (Rectangle/Square), Jerarquías Paralelas de Herencia (+2 more)

### Community 92 - "Community 92"
Cohesion: 0.20
Nodes (10): Directrices de Arquitectura para Views en UI de Escritorio, Anti-patrón: AddControl fuera de App, Tres reglas de comunicación (R1 dentro de feature, R2 EventBus, R3 App coordina), Components — partes privadas del Panel, Reglas de diseño verificables R1–R8, Anti-patrón: Feature importa otra feature, Feature — Módulo autocontenido, Anti-patrón: Capas huecas de propagación (+2 more)

### Community 93 - "Community 93"
Cohesion: 0.44
Nodes (10): AppManager (navigation contract), controllers/ layer, core/ layer (composition root), Architecture - TicTacToe Java, events/ layer, Layered DAG (Acyclic Dependencies Principle), libs/ layer, models/ layer (+2 more)

### Community 94 - "Community 94"
Cohesion: 0.20
Nodes (4): paquetes-casos-de-uso.puml, Vista de Escenarios (+1) — Casos de Uso y Secuencia, MainMenu, MainMenuFeatures

### Community 95 - "Community 95"
Cohesion: 0.31
Nodes (5): perfil.puml, secuencia-perfil.puml, LocalProfileController, ProfileFeature, ProfileRegistry

### Community 97 - "Community 97"
Cohesion: 0.29
Nodes (4): JsonStatisticsDao, TemporaryFolder, Test, JsonStatisticsDaoTest

### Community 99 - "Community 99"
Cohesion: 0.22
Nodes (9): Relaciones entre Clases, Agregación, Asociación, Composición, Dependencia (Uso), Ley de Demeter, Bajo Acoplamiento (Low Coupling), Memento con Originator — reusabilidad por interfaces (soluciones 8-9) (+1 more)

### Community 101 - "Community 101"
Cohesion: 0.39
Nodes (4): Gson, GsonCodec, Override, Type

### Community 107 - "Community 107"
Cohesion: 0.38
Nodes (3): Feature 1: Replay de Partida (Iterator), Override, MoveHistoryIterator

### Community 109 - "Community 109"
Cohesion: 0.33
Nodes (6): Explicación: C# Events en CitadelPanel, Delegates Action<T>/Func<T,TResult>, Palabra clave `event`, Múltiples suscriptores por evento, ?.Invoke() — disparo null-safe, Operadores += / -= (suscripción/desuscripción)

### Community 111 - "Community 111"
Cohesion: 0.53
Nodes (3): FileStatisticsDaoTest, TemporaryFolder, Test

### Community 112 - "Community 112"
Cohesion: 0.40
Nodes (5): Panel — UI pura, Service — Lógica de negocio, Panel — UI pura (genérico), Service — Lógica de negocio (genérico), Regla de Oro FSP: Panel emite intención → Service escucha → Service muta Panel

### Community 113 - "Community 113"
Cohesion: 0.40
Nodes (5): Single Gradle Module (java + application plugins), gson dependency (2.11.0), junit dependency (4.13.1), sqlite-jdbc dependency (3.53.2.0), Tests Setup (JUnit 4 classic, mirrors src/main structure)

### Community 114 - "Community 114"
Cohesion: 0.83
Nodes (3): gradlew script, die(), warn()

### Community 117 - "Community 117"
Cohesion: 0.67
Nodes (3): Builders — configuración declarativa de estilos, Builder (Constructor), Builder — configuración declarativa (genérico)

### Community 118 - "Community 118"
Cohesion: 0.67
Nodes (3): State objects — ejemplos de código (VisibilityState, DynamicHeightState, CollectionState), State objects (VisibilityState, ToggleState, CollectionState, PositionState, InputState, DynamicHeightState), State — máquina de estado encapsulada (genérico)

## Ambiguous Edges - Review These
- `core/bootstrap/ (AppContext, AppBootstrap, EventWiring)` → `Paso 6: Registrar en AppBootstrap.load()`  [AMBIGUOUS]
  .agents/design/feature-guide.md · relation: conceptually_related_to

## Knowledge Gaps
- **94 isolated node(s):** `recordToolUse.sh script`, `NOT_EMPTY`, `REPEATED_COORDINATE`, `NOT_PROPERTY`, `FIRST_WIN` (+89 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **23 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **What is the exact relationship between `core/bootstrap/ (AppContext, AppBootstrap, EventWiring)` and `Paso 6: Registrar en AppBootstrap.load()`?**
  _Edge tagged AMBIGUOUS (relation: conceptually_related_to) - confidence is low._
- **Why does `Coordinate` connect `Community 27` to `Community 1`, `Community 4`, `Community 5`, `Community 6`, `Community 7`, `Community 9`, `Community 11`, `Community 14`, `Community 15`, `Community 16`, `Community 20`, `Community 21`, `Community 23`, `Community 28`, `Community 35`, `Community 41`, `Community 42`, `Community 43`, `Community 46`, `Community 49`, `Community 50`, `Community 53`, `Community 54`, `Community 68`, `Community 73`, `Community 74`, `Community 75`, `Community 80`, `Community 84`, `Community 96`, `Community 98`, `Community 102`, `Community 103`, `Community 104`, `Community 119`, `Community 120`?**
  _High betweenness centrality (0.230) - this node is a cross-community bridge._
- **Why does `Player` connect `Community 11` to `Community 0`, `Community 1`, `Community 3`, `Community 5`, `Community 6`, `Community 7`, `Community 9`, `Community 14`, `Community 15`, `Community 16`, `Community 21`, `Community 23`, `Community 28`, `Community 30`, `Community 35`, `Community 40`, `Community 42`, `Community 44`, `Community 45`, `Community 46`, `Community 49`, `Community 50`, `Community 51`, `Community 53`, `Community 57`, `Community 63`, `Community 64`, `Community 68`, `Community 73`, `Community 80`, `Community 84`, `Community 95`, `Community 96`, `Community 97`, `Community 98`, `Community 103`?**
  _High betweenness centrality (0.156) - this node is a cross-community bridge._
- **Why does `GameSnapshot` connect `Community 14` to `Community 32`, `Community 0`, `Community 98`, `Community 67`, `Community 9`, `Community 107`, `Community 11`, `Community 12`, `Community 50`, `Community 52`, `Community 85`, `Community 20`, `Community 56`, `Community 27`, `Community 30`?**
  _High betweenness centrality (0.124) - this node is a cross-community bridge._
- **What connects `recordToolUse.sh script`, `NOT_EMPTY`, `REPEATED_COORDINATE` to the rest of the system?**
  _168 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Community 0` be split into smaller, more focused modules?**
  _Cohesion score 0.052214452214452214 - nodes in this community are weakly interconnected._
- **Should `Community 1` be split into smaller, more focused modules?**
  _Cohesion score 0.0625 - nodes in this community are weakly interconnected._
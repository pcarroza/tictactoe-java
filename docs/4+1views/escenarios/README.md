# Vista de Escenarios (+1) — Casos de Uso y Secuencia

El actor único es **Jugador** (app de consola, un solo usuario). `paquetes-casos-de-uso.puml` da la vista general por dominio; cada `.puml` de esta carpeta detalla los casos de uso reales de un dominio.

| Archivo | Dominio | Disparado por (código) |
|---|---|---|
| `partida.puml` | Partida | `GameMenu` → `StartGameCommand` → `GameModule` |
| `persistencia.puml` | Persistencia | `LoadGameCommand` → `LoadModule` |
| `repeticion.puml` | Repetición | `ReplayGameCommand` → `ReplayModule` |
| `estadisticas.puml` | Estadísticas | `ShowStatsCommand` → `StatisticsModule` |
| `logros.puml` | Logros | `ShowAchievementsCommand` → `AchievementsModule` |
| `perfil.puml` | Perfil | `ProfileCommand` → `ProfileModule` |

Todos estos comandos se registran en `views/console/core/menus/MainMenu.java`.

## Diagramas de secuencia

Complementan a los casos de uso: muestran **cómo** ocurre el escenario principal (camino feliz) de cada dominio paso a paso entre las clases reales. Las ramas alternativas del menú de turno (guardar, deshacer, rehacer, ver historial) están cubiertas por `../logica/patron-estado.puml`, no repetidas aquí.

| Archivo | Dominio |
|---|---|
| `secuencia-partida.puml` | Partida |
| `secuencia-persistencia.puml` | Persistencia |
| `secuencia-repeticion.puml` | Repetición |
| `secuencia-estadisticas.puml` | Estadísticas |
| `secuencia-logros.puml` | Logros |
| `secuencia-perfil.puml` | Perfil |

# Vista de Desarrollo

Responde a: ¿cómo se organiza el código en el repositorio? ¿qué depende de qué al compilar?

`componentes-build.puml` es el diagrama de esta vista: el módulo Gradle único y sus 3 dependencias externas (`gson`, `sqlite-jdbc`, `junit`). Complementa a `../logica/paquetes/paquetes-capas.puml` — ese muestra el DAG *funcional* de los 6 paquetes raíz; este muestra la unidad de *build* y sus dependencias de terceros.

## Módulo

Un único módulo Gradle (`build.gradle`), sin submódulos ni artefactos separados. Plugins `java` + `application`.

```gradle
dependencies {
    implementation 'com.google.code.gson:gson:2.11.0'      // JsonGameDao, JsonStatisticsDao
    implementation 'org.xerial:sqlite-jdbc:3.53.2.0'        // SqliteGameDao, SqliteStatisticsDao
    testImplementation 'junit:junit:4.13.1'
}
```

**Bug ya no reproduce** (verificado 2026-07-10): `application.mainClass` en `build.gradle` apunta correctamente a `'com.citadel.tictactoe.core.TicTacToeApp'`. `./gradlew run`/`./gradlew build` se ejecutaron con éxito repetidas veces en la sesión de refactor de Singleton (arranque JavaFX y consola), sin ningún error de clase no encontrada.

## Árbol de paquetes

Fuente de verdad: `src/main/java/com/citadel/tictactoe/`. Los 6 paquetes raíz forman el DAG documentado en `CLAUDE.md` y dibujado en `../logica/paquetes/paquetes-capas.puml`:

```
com.citadel.tictactoe/
  events/       — EventManager (Event Bus cross-module)
  shared/       — Terminal, LimitedIntDialog, YesNoDialog, ClosedInterval(View)
                  (equivalente al "libs" del DAG de CLAUDE.md — mismo rol,
                  nombre de paquete físico distinto; ver nota más abajo)
  models/       — entidades de dominio + persistence/ (DAO, Repository, Service)
  controllers/  — lógica de cada module (game, replay, achievements, ...)
  views/        — presentación consola + decoradores
  core/         — composition root (TicTacToeApp, AppConfig, EventWiring, modules/*)
```

Cada paquete de `controllers/`, `views/` y `models/` se subdivide en `modules/<nombre>/`, con una carpeta `local/` para la implementación concreta cuando aplica (p. ej. `controllers/modules/game/local/`). Los módulos nunca se importan entre sí — solo vía `EventManager` o `AppManager.navigateTo()`.

**Nota de nomenclatura**: `CLAUDE.md` y `.agents/design/package-dependency.md` llaman a esta capa base "`libs`"; el paquete físico en el código se llama `shared`. Es el mismo rol en el DAG (hoja sin dependencias, base utilities) — si se retoca esa documentación, unificar el nombre.

## Tests

`src/test/java/com/citadel/...` espeja la misma estructura de paquetes que `src/main`. Un único conjunto de tests con la dependencia `junit:junit:4.13.1` (JUnit 4) — `./gradlew test`. El bloque `test { }` de `build.gradle` llama tanto a `useJUnitPlatform()` como a `useJUnit()`; sin un engine JUnit 5/Vintage declarado como dependencia, el efectivo es `useJUnit()` (clásico JUnit 4, llamado en último lugar).

package com.citadel.tictactoe.core.config;

public class AppConfig {

    private static LogicType logicType;

    private static ViewType viewType;

    public static void set(LogicType logic, ViewType view) {
        logicType = logic;
        viewType = view;
    }

    public static LogicType logicType() {
        return logicType;
    }

    public static ViewType viewType() {
        return viewType;
    }
}

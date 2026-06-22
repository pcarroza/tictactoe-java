package main.core.config;

import main.controllers.Logic;
import main.controllers.features.game.local.logic.LocalGameLogic;

public enum LogicType {

    LOCAL {
        @Override
        public Logic create() {
            return new LocalGameLogic();
        }
    };

    public abstract Logic create();
}

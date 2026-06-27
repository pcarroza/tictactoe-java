package main.core.config;

import main.controllers.Logic;
import main.controllers.features.game.local.logic.LocalGameLogic;
import main.models.features.game.GameSnapshot;

public enum LogicType {

    LOCAL {
        @Override
        public Logic create() {
            return new LocalGameLogic();
        }

        @Override
        public Logic create(GameSnapshot snapshot) {
            return new LocalGameLogic(snapshot);
        }
    };

    public abstract Logic create();

    public abstract Logic create(GameSnapshot snapshot);
}

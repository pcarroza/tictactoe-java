package com.citadel.tictactoe.core.config;

import com.citadel.tictactoe.controllers.Logic;
import com.citadel.tictactoe.controllers.features.game.local.logic.LocalGameLogic;
import com.citadel.tictactoe.models.features.game.GameSnapshot;

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

package com.citadel.tictactoe.core.config;

import com.citadel.tictactoe.controllers.features.game.Logic;
import com.citadel.tictactoe.controllers.features.game.local.logic.LocalGameLogic;
import com.citadel.tictactoe.models.features.game.GameRegistry;
import com.citadel.tictactoe.models.features.game.GameSnapshot;

public enum LogicType {

    LOCAL {
        @Override
        public Logic create(GameRegistry gameRegistry) {
            return new LocalGameLogic(gameRegistry);
        }

        @Override
        public Logic create(GameSnapshot snapshot, GameRegistry gameRegistry) {
            return new LocalGameLogic(snapshot, gameRegistry);
        }
    };

    public abstract Logic create(GameRegistry gameRegistry);

    public abstract Logic create(GameSnapshot snapshot, GameRegistry gameRegistry);
}

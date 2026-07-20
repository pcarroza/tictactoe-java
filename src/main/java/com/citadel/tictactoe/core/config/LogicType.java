package com.citadel.tictactoe.core.config;

import com.citadel.tictactoe.controllers.modules.game.Logic;
import com.citadel.tictactoe.controllers.modules.game.local.logic.LocalGameLogic;
import com.citadel.tictactoe.models.modules.game.GameRegistry;
import com.citadel.tictactoe.models.modules.game.GameSnapshot;

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

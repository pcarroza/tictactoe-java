package com.citadel.tictactoe.controllers.modules.game.local.ai;

public enum AiDifficulty {

    EASY {
        @Override
        public AiStrategy createStrategy() {
            return new RandomAiStrategy();
        }
    },

    HARD {
        @Override
        public AiStrategy createStrategy() {
            return new MinimaxAiStrategy();
        }
    };

    public abstract AiStrategy createStrategy();
}

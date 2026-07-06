package com.citadel.tictactoe.controllers.features.game.local.ai;

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

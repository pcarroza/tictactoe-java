package com.citadel.tictactoe.models.features.game;

public abstract class ReplaySubject {

    private ReplayObserver observer;

    public void subscribe(ReplayObserver observer) {
        this.observer = observer;
    }

    public void exit() {
        this.observer.exit();
    }
}

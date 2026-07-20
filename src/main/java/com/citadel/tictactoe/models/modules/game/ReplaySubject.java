package com.citadel.tictactoe.models.modules.game;

public abstract class ReplaySubject {

    private ReplayObserver observer;

    public void subscribe(ReplayObserver observer) {
        this.observer = observer;
    }

    public void exit() {
        this.observer.exit();
    }
}

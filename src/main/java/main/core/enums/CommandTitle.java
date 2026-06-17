package main.core.enums;

public enum CommandTitle {

    START_GAME("Iniciar Juego");

    private final String title;

    CommandTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

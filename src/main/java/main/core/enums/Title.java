package main.core.enums;

public enum Title {

    START_GAME("Iniciar Juego");

    private final String title;

    Title(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

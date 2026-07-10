package com.citadel.tictactoe.models.persistence.repository.dao;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileSupport {

    private FileSupport() {
    }

    static void createDirectory(Path file) {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

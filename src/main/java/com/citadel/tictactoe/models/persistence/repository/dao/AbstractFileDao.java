package com.citadel.tictactoe.models.persistence.repository.dao;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

abstract class AbstractFileDao<T> {

    private final Path file;

    private final FileCodec<T> codec;

    AbstractFileDao(Path file, FileCodec<T> codec) {
        this.file = file;
        this.codec = codec;
    }

    protected T readOrDefault(T defaultValue) {
        if (!Files.exists(file)) {
            return defaultValue;
        }
        try {
            T result = codec.read(file);
            return result != null ? result : defaultValue;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    protected void write(T data) {
        FileSupport.createDirectory(file);
        try {
            codec.write(file, data);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

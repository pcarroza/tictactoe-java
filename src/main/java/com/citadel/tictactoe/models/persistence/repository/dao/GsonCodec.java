package com.citadel.tictactoe.models.persistence.repository.dao;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;

class GsonCodec<T> implements FileCodec<T> {

    private static final Gson GSON = new Gson();

    private final Type type;

    GsonCodec(Type type) {
        this.type = type;
    }

    @Override
    public T read(Path file) throws IOException {
        try (Reader reader = Files.newBufferedReader(file)) {
            return GSON.fromJson(reader, type);
        }
    }

    @Override
    public void write(Path file, T data) throws IOException {
        try (Writer writer = Files.newBufferedWriter(file)) {
            GSON.toJson(data, type, writer);
        }
    }
}

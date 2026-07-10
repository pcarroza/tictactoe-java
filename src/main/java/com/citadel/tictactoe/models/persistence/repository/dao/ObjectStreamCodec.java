package com.citadel.tictactoe.models.persistence.repository.dao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class ObjectStreamCodec<T> implements FileCodec<T> {

    @Override
    @SuppressWarnings("unchecked")
    public T read(Path file) throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            return (T) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Formato de datos corrupto en " + file, e);
        }
    }

    @Override
    public void write(Path file, T data) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
            out.writeObject(data);
        }
    }
}

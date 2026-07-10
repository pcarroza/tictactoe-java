package com.citadel.tictactoe.models.persistence.repository.dao;

import java.io.IOException;
import java.nio.file.Path;

interface FileCodec<T> {

    T read(Path file) throws IOException;

    void write(Path file, T data) throws IOException;
}

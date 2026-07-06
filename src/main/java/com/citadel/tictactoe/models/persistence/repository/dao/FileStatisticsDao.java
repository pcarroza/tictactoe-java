package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.persistence.models.StatisticsDto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class FileStatisticsDao implements StatisticsDao {

    private final Path file;

    public FileStatisticsDao(Path file) {
        this.file = file;
    }

    @Override
    public Optional<StatisticsDto> load() {
        if (!Files.exists(file)) {
            return Optional.empty();
        }
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(file))) {
            return Optional.of((StatisticsDto) in.readObject());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Formato de datos corrupto en " + file, e);
        }
    }

    @Override
    public void save(StatisticsDto dto) {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
            try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file))) {
                out.writeObject(dto);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

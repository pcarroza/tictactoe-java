package com.citadel.tictactoe.models.persistence.repository.dao;

import com.citadel.tictactoe.models.persistence.models.StatisticsDto;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class JsonStatisticsDao implements StatisticsDao {

    private static final Gson GSON = new Gson();

    private final Path file;

    public JsonStatisticsDao(Path file) {
        this.file = file;
    }

    @Override
    public Optional<StatisticsDto> load() {
        if (!Files.exists(file)) {
            return Optional.empty();
        }
        try (Reader reader = Files.newBufferedReader(file)) {
            return Optional.ofNullable(GSON.fromJson(reader, StatisticsDto.class));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void save(StatisticsDto dto) {
        try {
            if (file.getParent() != null) {
                Files.createDirectories(file.getParent());
            }
            try (Writer writer = Files.newBufferedWriter(file)) {
                GSON.toJson(dto, writer);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

package data.board;

import data.FileObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class BoardFileReader<T> implements FileObjectMapper<T> {

    public T read(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().
                    map(this::mapToObject).
                    filter(Objects::nonNull).
                    collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

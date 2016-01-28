package data.boardcase;

import data.FileObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public abstract class BoardCaseFileReader<T> implements FileObjectMapper<T> {

    public List<T> read(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().
                    map(this::mapToObject).
                    filter(Objects::nonNull).
                    collect(toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

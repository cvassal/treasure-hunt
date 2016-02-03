package data.boardcase;

import data.FileObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public abstract class BoardCaseFileReader<T> implements FileObjectMapper<T> {

    public List<T> read(File file) {
        try {
            return Files.readAllLines(Paths.get(file.toURI()))
                    .stream()
                    .map(this::mapToObject)
                    .filter(Objects::nonNull)
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

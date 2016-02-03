package data.adventurer;

import data.FileObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class AdventurerFileReader<T> implements FileObjectMapper<T> {

    public List<T> read(File file) {
        try {
            return Files.readAllLines(Paths.get(file.toURI()))
                    .stream()
                    .map(this::mapToObject)
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

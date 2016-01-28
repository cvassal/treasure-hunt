package data.adventurer;

import data.FileObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class AdventurerFileReader<T> implements FileObjectMapper<T> {

    public List<T> read(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().
                    map(this::mapToObject).
                    collect(toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

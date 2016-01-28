package data.adventurer;


import data.FileUtils;
import domain.adventurer.Adventurer;
import domain.adventurer.Coordinate;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AdventurerAdventurerFileReaderTest {

    @Test
    public void should_read_from_file() throws IOException {
        AdventurerParamFileReader reader = new AdventurerParamFileReader();

        List<Adventurer> adventurers = reader.fromFile(new FileUtils().getFileFromClassPath("Test.txt"));

        assertThat(adventurers).hasSize(1);
        assertThat(adventurers.get(0).getPosition()).isEqualTo(new Coordinate(1, 1));
    }
}
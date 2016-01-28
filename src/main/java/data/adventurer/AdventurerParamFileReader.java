package data.adventurer;

import com.google.common.primitives.Chars;
import domain.adventurer.Adventurer;
import domain.adventurer.Coordinate;
import domain.adventurer.Direction;

import java.io.File;
import java.util.List;

public class AdventurerParamFileReader extends AdventurerFileReader<Adventurer> {

    public List<Adventurer> fromFile(File file) {
        return this.read(file);
    }

    public Adventurer mapToObject(String stringAdventurer) {
        String[] adventurerProperties = stringAdventurer.split(" ");

        return Adventurer.builder()
                .name(adventurerProperties[0])
                .position(Coordinate.parseFromString(adventurerProperties[1]))
                .direction(Direction.fromLetter(adventurerProperties[2]))
                .movements(Chars.asList(adventurerProperties[3].toCharArray()))
                .build();
    }
}

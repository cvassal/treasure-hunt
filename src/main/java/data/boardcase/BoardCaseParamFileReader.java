package data.boardcase;

import domain.adventurer.Coordinate;
import domain.board.element.Mountain;
import domain.board.element.Treasure;

import java.io.File;
import java.util.List;

import static java.lang.Integer.parseInt;

public class BoardCaseParamFileReader extends BoardCaseFileReader<BoardCase> {

    public List<BoardCase> fromFile(File file) {
        return this.read(file);
    }

    public BoardCase mapToObject(String stringCase) {
        String[] caseProperties = stringCase.split(" ");
        String[] coordinates;
        int x;
        int y;

        switch (caseProperties[0]) {
            case "T":
                int numberOfTreasure = parseInt(caseProperties[2]);
                Treasure treasure = new Treasure(numberOfTreasure);
                coordinates = caseProperties[1].split("-");
                x = parseInt(coordinates[0]);
                y = parseInt(coordinates[1]);
                return BoardCase.builder()
                        .boardCase(treasure)
                        .coordinate(new Coordinate(x, y))
                        .build();
            case "M":
                Mountain mountain = new Mountain();
                coordinates = caseProperties[1].split("-");
                x = parseInt(coordinates[0]);
                y = parseInt(coordinates[1]);
                return BoardCase.builder()
                        .boardCase(mountain)
                        .coordinate(new Coordinate(x, y))
                        .build();
            default:
                return null;
        }
    }
}

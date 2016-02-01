package data.board;

import domain.board.Board;
import domain.board.Size;

import java.io.File;

import static java.lang.Integer.parseInt;

public class BoardParamFileReader extends BoardFileReader<Board> {

    public Board fromFile(File file) {
        return this.read(file);
    }

    public Board mapToObject(String stringCase) {
        String[] caseProperties = stringCase.split(" ");
        String[] coordinates;
        int x;
        int y;

        switch (caseProperties[0]) {
            case "C":
                coordinates = caseProperties[1].split("-");
                x = parseInt(coordinates[0]);
                y = parseInt(coordinates[1]);
                return new Board(new Size(x, y));
        }
        return null;
    }
}

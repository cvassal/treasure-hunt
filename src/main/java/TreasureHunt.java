import data.FileUtils;
import data.adventurer.AdventurerParamFileReader;
import data.board.BoardParamFileReader;
import data.boardcase.BoardCase;
import data.boardcase.BoardCaseParamFileReader;
import domain.adventurer.Adventurer;
import domain.board.Board;

import java.io.File;
import java.util.List;

public class TreasureHunt {

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        File boardParameterFile = new FileUtils().getFileFromClassPath("BoardParam.txt");


        BoardParamFileReader boardReader = new BoardParamFileReader();
        Board board = boardReader.fromFile(boardParameterFile);

        BoardCaseParamFileReader boardCaseReader = new BoardCaseParamFileReader();
        List<BoardCase> boardCases = boardCaseReader.fromFile(boardParameterFile);
        board.setCases(boardCases);

        AdventurerParamFileReader adventurerFileReader = new AdventurerParamFileReader();
        List<Adventurer> adventurers = adventurerFileReader.fromFile(fileUtils.getFileFromClassPath("AdventurerParam.txt"));
        adventurers.stream().forEach(adventurer -> {
            adventurer.huntOn(board);
            adventurer.goHunt();
        });
    }
}

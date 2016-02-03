import data.FileUtils;
import data.adventurer.AdventurerParamFileReader;
import data.board.BoardParamFileReader;
import data.boardcase.BoardCase;
import data.boardcase.BoardCaseParamFileReader;
import domain.adventurer.Adventurer;
import domain.board.Board;
import service.MovementService;

import java.io.File;
import java.util.List;

public class App {
    private List<Adventurer> adventurers;

    private static List<Adventurer> initAdventurers(FileUtils fileUtils, Board board) {
        AdventurerParamFileReader adventurerFileReader = new AdventurerParamFileReader();
        List<Adventurer> adventurers = adventurerFileReader.fromFile(fileUtils.getFileFromClassPath("AdventurerParam.txt"));

        adventurers
                .stream()
                .forEach(adventurer -> adventurer.huntOn(board));

        return adventurers;
    }

    private static Board initBoard() {
        File boardParameterFile = new FileUtils().getFileFromClassPath("BoardParam.txt");

        BoardParamFileReader boardReader = new BoardParamFileReader();
        Board board = boardReader.fromFile(boardParameterFile);

        BoardCaseParamFileReader boardCaseReader = new BoardCaseParamFileReader();
        List<BoardCase> boardCases = boardCaseReader.fromFile(boardParameterFile);
        board.setCases(boardCases);

        return board;
    }

    public void initApp() {
        FileUtils fileUtils = new FileUtils();
        Board board = initBoard();
        adventurers = initAdventurers(fileUtils, board);
    }

    public void start() {
        adventurers
                .parallelStream()
                .forEach(adventurer -> new MovementService(adventurer).goHunt());
    }
}

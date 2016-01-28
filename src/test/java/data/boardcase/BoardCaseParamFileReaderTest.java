package data.boardcase;

import data.FileUtils;
import domain.adventurer.Coordinate;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardCaseParamFileReaderTest {

    @Test
    public void should_read_from_file() throws IOException {
        BoardCaseParamFileReader reader = new BoardCaseParamFileReader();

        List<BoardCase> boardCases = reader.fromFile(new FileUtils().getFileFromClassPath("BoardTest.txt"));

        assertThat(boardCases).hasSize(2);
        assertThat(boardCases).extracting("coordinate").contains(new Coordinate(3, 1), new Coordinate(4, 1));
    }
}
package data.board;

import data.FileUtils;
import domain.board.Board;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardParamFileReaderTest {

    @Test
    public void should_read_from_file() throws IOException {
        BoardParamFileReader reader = new BoardParamFileReader();

        Board board = reader.fromFile(new FileUtils().getFileFromClassPath("BoardTest.txt"));

        assertThat(board.isEmpty()).isFalse();
    }

}
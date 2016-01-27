package domain.board.element;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MountainTest {

    @Test
    public void should_not_be_crossable() throws Exception {
        Case testCase = new Mountain();

        assertThat(testCase.isCrossable()).isFalse();
    }
}
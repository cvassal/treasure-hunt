package domain.board.element;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LandTest {

    @Test
    public void should_be_crossable() throws Exception {
        Case land = Land.builder().build();

        assertThat(land.isCrossable()).isTrue();
    }
}
package domain.board.element;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TreasureTest {


    @Test
    public void should_be_crossable() {
        Treasure treasure = new Treasure(3);

        assertThat(treasure.isCrossable()).isTrue();
    }

    @Test
    public void should_contain_some_treasure() {
        Treasure treasure = new Treasure(1);

        assertThat(treasure.getQuantity()).isEqualTo(1);
    }
}
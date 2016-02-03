package service;

import domain.adventurer.Adventurer;
import domain.adventurer.Direction;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionServiceTest {

    @Test
    public void should_turn_from_north_to_east() {
        Adventurer hunter = Adventurer.builder().direction(Direction.NORTH).build();
        DirectionService directionService = new DirectionService();

        Direction nextDirection = directionService.turnRight(hunter.getDirection());

        assertThat(nextDirection).isEqualTo(Direction.EAST);
    }

    @Test
    public void should_turn_from_east_to_north() {
        Adventurer hunter = Adventurer.builder().direction(Direction.EAST).build();
        DirectionService directionService = new DirectionService();

        Direction nextDirection = directionService.turnLeft(hunter.getDirection());

        assertThat(nextDirection).isEqualTo(Direction.NORTH);
    }

    @Test
    public void should_turn_from_west_to_north() {
        Adventurer hunter = Adventurer.builder().direction(Direction.WEST).build();
        DirectionService directionService = new DirectionService();

        Direction nextDirection = directionService.turnRight(hunter.getDirection());

        assertThat(nextDirection).isEqualTo(Direction.NORTH);
    }

    @Test
    public void should_turn_from_north_to_west() {
        Adventurer hunter = Adventurer.builder().direction(Direction.NORTH).build();
        DirectionService directionService = new DirectionService();

        Direction nextDirection = directionService.turnLeft(hunter.getDirection());

        assertThat(nextDirection).isEqualTo(Direction.WEST);
    }
}
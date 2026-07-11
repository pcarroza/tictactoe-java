package com.citadel.tictactoe.models.features.game.coordinate;

import com.citadel.tictactoe.models.features.game.Direction;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NullCoordinateTest {

    private final Coordinate nullCoordinate = Coordinate.NULL;

    @Test
    public void givenTheNullCoordinateConstant_whenCheckingIsNull_thenReturnsTrue() {
        assertThat(nullCoordinate.isNull(), is(true));
    }

    @Test
    public void givenTheNullCoordinateConstant_whenGettingDirection_thenReturnsNonExistent() {
        assertThat(nullCoordinate.getDirection(new ConcreteCoordinate(1, 1)), is(Direction.NON_EXISTENT));
    }

    @Test
    public void givenTheNullCoordinateConstant_whenCheckingHorizontalAlignment_thenReturnsFalse() {
        assertThat(nullCoordinate.inHorizontal(new ConcreteCoordinate(1, 1)), is(false));
    }

    @Test
    public void givenTheNullCoordinateConstant_whenCheckingVerticalAlignment_thenReturnsFalse() {
        assertThat(nullCoordinate.inVertical(new ConcreteCoordinate(1, 1)), is(false));
    }

    @Test
    public void givenTheNullCoordinateConstant_whenCheckingDiagonalAlignment_thenReturnsFalse() {
        assertThat(nullCoordinate.inDiagonal(), is(false));
    }
}

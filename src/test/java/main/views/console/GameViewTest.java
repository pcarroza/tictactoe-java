package main.views.console;

import main.controllers.MoveController;
import main.controllers.PutController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameViewTest {

    private GameView gameView;

    @Mock
    private PutController putController;

    @Mock
    private MoveController moveController;

    private final int INVOCATIONS = 1;

    @Before
    public void setUp() {
        gameView = new GameView(mock(BoardView.class));
    }

    @Test
    public void givenGameView_whenGameViewIsCreated_thenGameViewIsNotNull() {
        assertThat(gameView, is(notNullValue()));
    }

    @Test
    public void givenGameView_whenInteractWithPutController_themVerifyPutControllerCallMethodAccept() {
        doNothing().when(putController).accept(any(GameView.class));
        gameView.interact(putController);
        verify(putController, times(INVOCATIONS)).accept(gameView);
    }

    @Test
    public void givenGameView_whenInteractWithMoveController_themVerifyMoveControllerCallMethodAccept() {
        doNothing().when(moveController).accept(any(GameView.class));
        gameView.interact(moveController);
        verify(moveController, times(INVOCATIONS)).accept(gameView);
    }
}

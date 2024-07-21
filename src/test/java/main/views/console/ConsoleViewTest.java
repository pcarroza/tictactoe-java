package main.views.console;

import main.controllers.ContinueController;
import main.controllers.PlacementController;
import main.controllers.StartController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleViewTest {

    @InjectMocks
    private ConsoleView consoleView;

    private final int INVOCATIONS = 1;

    @Test
    public void givenConsoleView_whenConsoleViewIsCreated_thenConsoleViewIsNotNull() {
        assertThat(consoleView, is(notNullValue()));
    }

    @Test
    public void givenConsoleView_whenStartControllerInteractWithThis_thenVerifyStartControllerAcceptMethod() {
        StartController startController = mock(StartController.class);
        doNothing().when(startController).accept(consoleView);
        consoleView.interact(startController);
        verify(startController, times(INVOCATIONS)).accept(consoleView);
    }

    @Test
    public void givenConsoleView_whenPlacementControllerInteractWithThis_thenVerifyPlacementControllerAcceptMethod() {
        PlacementController placementController = mock(PlacementController.class);
        doNothing().when(placementController).accept(consoleView);
        consoleView.interact(placementController);
        verify(placementController, times(INVOCATIONS)).accept(consoleView);
    }

    @Test
    public void givenConsoleView_whenContinueControllerInteractWithThis_thenVerifyContinueControllerAcceptMethod() {
        ContinueController continueController = mock(ContinueController.class);
        doNothing().when(continueController).accept(consoleView);
        consoleView.interact(continueController);
        verify(continueController, times(INVOCATIONS)).accept(consoleView);
    }
}

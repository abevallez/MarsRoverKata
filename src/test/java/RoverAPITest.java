import static org.mockito.Mockito.*;

import org.junit.Test;

public class RoverAPITest {

    @Test
    public void shouldRotateRight() {
        Rover rover = mock(Rover.class);
        RoverAPI roverController = new RoverAPI(rover);
        roverController.execute("r");
        verify(rover).rotateRight();
    }

}

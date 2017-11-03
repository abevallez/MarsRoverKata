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

    @Test
    public void shouldRotateRightTwice() {
        Rover rover = mock(Rover.class);
        RoverAPI roverController = new RoverAPI(rover);
        roverController.execute("r,r");
        verify(rover, times(2)).rotateRight();
    }

    @Test
    public void shouldRotateLeft() {
        Rover rover = mock(Rover.class);
        RoverAPI roverController = new RoverAPI(rover);
        roverController.execute("l");
        verify(rover).rotateLeft();
    }

    @Test
    public void shouldRotateLeftTwice() {
        Rover rover = mock(Rover.class);
        RoverAPI roverController = new RoverAPI(rover);
        roverController.execute("l,l");
        verify(rover, times(2)).rotateLeft();
    }

}

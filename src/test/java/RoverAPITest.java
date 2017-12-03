import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class RoverAPITest {

    private Rover rover;
    private RoverAPI roverController;

    @Before
    public void setUp() {
        this.rover = mock(Rover.class);
        this.roverController = new RoverAPI(rover);
    }

    @Test
    public void shouldRotateRight() {
        this.roverController.execute("r");
        verify(rover).rotateRight();
    }

    @Test
    public void shouldRotateRightTwice() {
        this.roverController.execute("r,r");
        verify(rover, times(2)).rotateRight();
    }

    @Test
    public void shouldRotateLeft() {
        this.roverController.execute("l");
        verify(rover).rotateLeft();
    }

    @Test
    public void shouldRotateLeftTwice() {
        this.roverController.execute("l,l");
        verify(rover, times(2)).rotateLeft();
    }

    @Test
    public void shouldGoForward() {
        this.roverController.execute("f");
        verify(rover, times(1)).moveForward();
    }

    @Test
    public void shouldGoBackward() {
        this.roverController.execute("b");
        verify(rover, times(1)).moveBackward();
    }
}

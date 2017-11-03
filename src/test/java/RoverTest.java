import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class RoverTest {

    @Test
    public void shouldRotateRight() {
        Rover rover = new Rover();
        rover.rotateRight();
        assertThat(rover.getPosition()).isEqualTo("0,0,E");
    }
}

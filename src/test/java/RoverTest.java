import static org.assertj.core.api.Assertions.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RoverTest {

    @Test
    public void shouldInitWith00NCoordinatesIfEmpty() {
        Rover rover = new Rover();
        assertThat(rover.getCoordinates()).isEqualTo(new Integer[]{0,0});
        assertThat(rover.getDirection()).isEqualTo('N');
    }

    @Test
    @Parameters({
            "0,0,N",
            "5,7,S",
            "1,3,E",
            "4,6,W"
    })
    public void shouldInitWithCoordinatesAndDirectionGiven(Integer x, Integer y, Character direction) {
        Rover rover = new Rover(x,y,direction);
        assertThat(rover.getCoordinates()).isEqualTo(new Integer[]{x,y});
        assertThat(rover.getDirection()).isEqualTo(direction);
    }

    @Test
    @Parameters({
            "N,E",
            "E,S",
            "S,W",
            "W,N"
    })
    public void shouldTurnRightDirection(Character originalDirection, Character finalDirection) {
        Rover rover = new Rover(0,0,originalDirection);
        rover.rotateRight();
        assertThat(rover.getDirection()).isEqualTo(finalDirection);
    }

    @Test
    @Parameters({
            "N,W",
            "W,S",
            "S,E",
            "E,N"
    })
    public void shouldTurnLeftDirection(Character originalDirection, Character finalDirection) {
        Rover rover = new Rover(0,0,originalDirection);
        rover.rotateLeft();
        assertThat(rover.getDirection()).isEqualTo(finalDirection);
    }
}

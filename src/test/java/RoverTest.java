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
        assertThat(rover.getPosition()).isEqualToComparingFieldByField(new Coordinates(0,0));
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
        Coordinates position = new Coordinates(x,y);
        Rover rover = new Rover(position,direction);
        assertThat(rover.getPosition()).isEqualTo(position);
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
        Coordinates Coordinates = new Coordinates(0,0);
        Rover rover = new Rover(Coordinates,originalDirection);
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
        Coordinates Coordinates = new Coordinates(0,0);
        Rover rover = new Rover(Coordinates,originalDirection);
        rover.rotateLeft();
        assertThat(rover.getDirection()).isEqualTo(finalDirection);
    }

    @Test
    @Parameters(method = "CoordinatesGoForwardProvider")
    public void shouldGoForward(Coordinates position, Character initDirection, Coordinates finalPosition) {
        Rover rover = new Rover(position,initDirection);
        rover.moveForward();
        assertThat(rover.getDirection()).isEqualTo(initDirection);
        assertThat(rover.getPosition()).isEqualToComparingFieldByField(finalPosition);
    }

    private Object CoordinatesGoForwardProvider() {
        return new Object[]{
            new Object[]{new Coordinates(0,0), "N", new Coordinates(0,1)},
            new Object[]{new Coordinates(0,9), "S", new Coordinates(0,8)},
            new Object[]{new Coordinates(9,0), "E", new Coordinates(8,0)},
            new Object[]{new Coordinates(0,0), "W", new Coordinates(1,0)},
            new Object[]{new Coordinates(0,8), "N", new Coordinates(0,9)},
            new Object[]{new Coordinates(0,8), "S", new Coordinates(0,7)},
            new Object[]{new Coordinates(8,0), "E", new Coordinates(7,0)},
            new Object[]{new Coordinates(8,0), "W", new Coordinates(9,0)},
        };
    }

    @Test
    @Parameters(method = "CoordinatesGoBackwardProvider")
    public void shouldBackward(Coordinates initPosition, Character initDirection, Coordinates finalPosition) {
        Rover rover = new Rover(initPosition, initDirection);
        rover.moveBackward();
        assertThat(rover.getDirection()).isEqualTo(initDirection);
        assertThat(rover.getPosition()).isEqualToComparingFieldByField(finalPosition);
    }

    private Object CoordinatesGoBackwardProvider() {
        return new Object[]{
                new Object[]{new Coordinates(0,9), "N", new Coordinates(0,8)},
                new Object[]{new Coordinates(0,8), "S", new Coordinates(0,9)},
                new Object[]{new Coordinates(8,0), "E", new Coordinates(9,0)},
                new Object[]{new Coordinates(1,0), "W", new Coordinates(0,0)},
                new Object[]{new Coordinates(0,8), "N", new Coordinates(0,7)},
                new Object[]{new Coordinates(0,2), "S", new Coordinates(0,3)},
                new Object[]{new Coordinates(0,0), "E", new Coordinates(1,0)},
                new Object[]{new Coordinates(8,0), "W", new Coordinates(7,0)},
        };
    }

    @Test
    @Parameters(method = "WrapMovingForwardProvider")
    public void shouldWrapFromOneEdgeOfTheGridToAnotherMovingForward(Coordinates initPosition, Character initDirection, Coordinates finalPosition) {
        Rover rover = new Rover(initPosition,initDirection);
        rover.moveForward();
        assertThat(rover.getDirection()).isEqualTo(initDirection);
        assertThat(rover.getPosition()).isEqualToComparingFieldByField(finalPosition);
    }

    private Object WrapMovingForwardProvider() {
        return new Object[]{
                new Object[]{new Coordinates(0,9), "N", new Coordinates(0,0)},
                new Object[]{new Coordinates(0,0), "S", new Coordinates(0,9)},
                new Object[]{new Coordinates(0,0), "E", new Coordinates(9,0)},
                new Object[]{new Coordinates(9,0), "W", new Coordinates(0,0)},
        };
    }

    @Test
    @Parameters(method = "WrapMovingBackwardProvider")
    public void shouldWrapFromOneEdgeOfTheGridToAnotherMovingBackward(Coordinates initPosition, Character initDirection, Coordinates finalPosition) {
        Rover rover = new Rover(initPosition,initDirection);
        rover.moveBackward();
        assertThat(rover.getDirection()).isEqualTo(initDirection);
        assertThat(rover.getPosition()).isEqualToComparingFieldByField(finalPosition);
    }

    private Object WrapMovingBackwardProvider() {
        return new Object[]{
                new Object[]{new Coordinates(0,9), "S", new Coordinates(0,0)},
                new Object[]{new Coordinates(0,0), "N", new Coordinates(0,9)},
                new Object[]{new Coordinates(0,0), "W", new Coordinates(9,0)},
                new Object[]{new Coordinates(9,0), "E", new Coordinates(0,0)},
        };
    }
}

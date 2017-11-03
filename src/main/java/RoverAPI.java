public class RoverAPI {
    Rover rover;

    public RoverAPI(Rover rover) {
        this.rover = rover;
    }

    public void execute(String command) {
        rover.rotateRight();
    }
}

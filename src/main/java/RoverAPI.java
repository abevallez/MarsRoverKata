public class RoverAPI {
    Rover rover;

    public RoverAPI(Rover rover) {
        this.rover = rover;
    }

    public void execute(String commands) {
        String[] commandsSplit = commands.split(",");
        for (String command: commandsSplit) {
            if ("l".equals(command)) {
                rover.rotateLeft();
            }
            rover.rotateRight();
        }

    }
}

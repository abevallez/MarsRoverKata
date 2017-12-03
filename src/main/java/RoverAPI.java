public class RoverAPI {
    Rover rover;

    public RoverAPI(Rover rover) {
        this.rover = rover;
    }

    public void execute(String commands) {
        char[] commandsSplit = commands.toCharArray();
        for (char command: commandsSplit) {
            switch (command) {
                case 'l':
                    rover.rotateLeft();
                    break;
                case 'r':
                    rover.rotateRight();
                    break;
                case 'f':
                    rover.moveForward();
                    break;
                case 'b':
                    rover.moveBackward();
                    break;
            }
        }
    }
}

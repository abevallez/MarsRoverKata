public class Rover {

    private static final Character NORTH = 'N';
    private static final Character SOUTH = 'S';
    private static final Character WEST = 'W';
    private static final Character EAST = 'E';

    private Character direction;
    private Integer[] coordinates = new Integer[2];

    public Rover() {
        this.coordinates[0] = 0;
        this.coordinates[1] = 0;
        this.direction = NORTH;
    }

    public Rover(Integer x, Integer y, Character direction) {
        this.coordinates[0] = x;
        this.coordinates[1] = y;
        this.direction = direction;
    }

    public void rotateRight() {
        if (getDirection().equals(EAST)) {
            this.direction = SOUTH;
        } else if (getDirection().equals(SOUTH)) {
            this.direction = WEST;
        }else if (getDirection().equals(WEST)) {
            this.direction = NORTH;
        }else if (getDirection().equals(NORTH)) {
            this.direction = EAST;
        }
    }

    public void rotateLeft() {
        if (getDirection().equals(EAST)) {
            this.direction = NORTH;
        } else if (getDirection().equals(SOUTH)) {
            this.direction = EAST;
        }else if (getDirection().equals(WEST)) {
            this.direction = SOUTH;
        }else if (getDirection().equals(NORTH)) {
            this.direction = WEST;
        }
    }

    public Character getDirection() {
        return direction;
    }

    public Integer[] getCoordinates() {
        return coordinates;
    }


}

public class Rover {

    private static final Character NORTH = 'N';
    private static final Character SOUTH = 'S';
    private static final Character WEST = 'W';
    private static final Character EAST = 'E';

    private Character direction;
    private Coordinates position;

    public Rover() {
        this.position = new Coordinates(0,0);
        this.direction = NORTH;
    }

    public Rover(Coordinates position, Character direction) {
        this.position = position;
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

    public void moveForward() {
        switch (this.direction) {
            case 'N':
                this.position = this.position.setY(this.position.getY() + 1);
                break;
            case 'W':
                this.position = this.position.setX(this.position.getX() + 1);
                break;
            case 'E':
                this.position = this.position.setX(this.position.getX() - 1);
                break;
            case 'S':
                this.position = this.position.setY(this.position.getY() - 1);
                break;
        }

        this.wrapXAxis();
        this.wrapYAxis();
    }

    public void moveBackward() {
        switch (getDirection()) {
            case 'N':
                this.position = this.position.setY(this.position.getY() - 1);
                break;
            case 'W':
                this.position = this.position.setX(this.position.getX() - 1);
                break;
            case 'E':
                this.position = this.position.setX(this.position.getX() + 1);
                break;
            case 'S':
                this.position = this.position.setY(this.position.getY() + 1);
                break;
        }

        this.wrapYAxis();
        this.wrapXAxis();
    }

    private void wrapYAxis() {
        if (this.position.getX() == 10) {
            this.position = this.position.setX(0);
        } else if (this.position.getX() == -1) {
            this.position = this.position.setX(9);
        }
    }

    private void wrapXAxis() {
        if (this.position.getY() == 10) {
            this.position = this.position.setY(0);
        } else if (this.position.getY() == -1) {
            this.position = this.position.setY(9);
        }
    }

    public Character getDirection() {
        return this.direction;
    }

    public Coordinates getPosition() {
        return this.position;
    }
}

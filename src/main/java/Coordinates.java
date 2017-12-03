public class Coordinates {

    private Integer x;
    private Integer y;

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Coordinates setX(Integer x) {
        return new Coordinates(x, this.y);
    }

    public Integer getY() {
        return y;
    }

    public Coordinates setY(Integer y) {
        return new Coordinates(this.x, y);
    }
}

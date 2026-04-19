public class Square extends Shape {
    private int side;

    public Square(Coordinates coord, int side) {
        super(4, coord);
        this.side = side;
    }

    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);

        if (sign) {
            this.side *= factor;
        } else {
            this.side /= factor;
        }
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String display() {
        return "Shape: Square\nPosition: " + position.display() +
                "\nSide: " + side +
                "\nArea: " + String.format("%.2f", getArea()) +
                "\nPerimeter: " + String.format("%.2f", getPerimeter());
    }
}
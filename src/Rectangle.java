public class Rectangle extends Shape {
    private int width;
    private int length;

    public Rectangle(Coordinates coord, int width, int length) {
        super(4, coord);
        this.width = width;
        this.length = length;
    }

    @Override
    public void scale(int factor, boolean sign) {
        position.scale(factor, sign);

        if (sign) {
            this.width *= factor;
            this.length *= factor;
        } else {
            this.width /= factor;
            this.length /= factor;
        }
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String display() {
        return "Shape: Rectangle\nPosition: " + position.display() +
                "\nWidth: " + width +
                "\nLength: " + length +
                "\nArea: " + String.format("%.2f", getArea()) +
                "\nPerimeter: " + String.format("%.2f", getPerimeter());
    }
}
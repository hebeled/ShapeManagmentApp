public class Triangle extends Shape {
    private Coordinates vertex1;
    private Coordinates vertex2;
    private Coordinates vertex3;

    public Triangle(Coordinates vertex1, Coordinates vertex2, Coordinates vertex3) {
        super(3, vertex1);
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    @Override
    public void translate(int dx, int dy) {
        vertex1.translate(dx, dy);
        vertex2.translate(dx, dy);
        vertex3.translate(dx, dy);
    }

    @Override
    public void scale(int factor, boolean sign) {
        vertex1.scale(factor, sign);
        vertex2.scale(factor, sign);
        vertex3.scale(factor, sign);
    }

    @Override
    public double getArea() {
        double a = vertex1.distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(vertex1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        double a = vertex1.distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(vertex1);
        return a + b + c;
    }

    @Override
    public String display() {
        return "Shape: Triangle\n" +
                "Vertex 1: " + vertex1.display() + "\n" +
                "Vertex 2: " + vertex2.display() + "\n" +
                "Vertex 3: " + vertex3.display() + "\n" +
                "Area: " + String.format("%.2f", getArea()) + "\n" +
                "Perimeter: " + String.format("%.2f", getPerimeter());
    }
}
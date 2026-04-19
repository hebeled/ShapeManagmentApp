import java.util.ArrayList;

public class ShapeList {
    private ArrayList<Shape> listOfShapes;

    // Constructor to create an empty list of shapes
    public ShapeList() {
        listOfShapes = new ArrayList<>();
    }

    // Adds a shape to the list
    public void addShape(Shape s) {
        listOfShapes.add(s);
    }

    // Translates all shapes in the list
    public void translateShapes(int dx, int dy) {
        for (Shape each : listOfShapes) {
            each.translate(dx, dy);
        }
    }

    // Returns a shape by its ID
    public Shape getShape(int id) {
        return listOfShapes.get(id - 1);
    }

    // Removes a shape by its ID
    public Shape removeShape(int id) {
        return listOfShapes.remove(id - 1);
    }

    // Returns the area of a shape by its ID
    public double area(int id) {
        return listOfShapes.get(id - 1).getArea();
    }

    // Scales all shapes in the list
    public void scale(int factor, boolean sign) {
        for (Shape each : listOfShapes) {
            each.scale(factor, sign);
        }
    }

    // Returns the perimeter of a shape by its ID
    public double perimeter(int id) {
        return listOfShapes.get(id - 1).getPerimeter();
    }

    // Returns information about all shapes in the list
    public String display() {
        if (listOfShapes.isEmpty()) {
            return "No shapes in the list.";
        }

        StringBuilder displayString = new StringBuilder();
        int id = 1;

        for (Shape each : listOfShapes) {
            displayString.append("ID: ").append(id).append("\n");
            displayString.append(each.display()).append("\n\n");
            id++;
        }

        return displayString.toString();
    }

    // Returns the number of shapes in the list
    public int size() {
        return listOfShapes.size();
    }

    // Checks whether the given ID is valid
    public boolean isValid(int id) {
        return id > 0 && id <= listOfShapes.size();
    }
}
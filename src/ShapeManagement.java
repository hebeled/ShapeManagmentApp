import java.util.Scanner;

public class ShapeManagement {
    private final ShapeList shapeList = new ShapeList();
    private final Scanner scanner = new Scanner(System.in);

    // Asks the user whether to continue using the program
    private boolean wannaContinue() {
        while (true) {
            System.out.print("\nDo you want to continue the program? (Y/N) >> ");
            char option = scanner.next().toUpperCase().charAt(0);

            if (option == 'Y') {
                System.out.println("\n===== Shape Management Program =====\n");
                return true;
            } else if (option == 'N') {
                System.out.println("\nThank you for using the program!");
                return false;
            } else {
                System.out.println("Invalid input! Please type Y or N.");
            }
        }
    }

    // Displays the main menu and handles user choices
    public void optionMenu() {
        String menu = "\n____ Menu _____";
        menu += "\n1. Add a shape";
        menu += "\n2. Remove a shape by ID";
        menu += "\n3. Get information about a shape by ID";
        menu += "\n4. Area and perimeter of a shape by ID";
        menu += "\n5. Display information of all shapes";
        menu += "\n6. Translate all shapes";
        menu += "\n7. Scale all shapes";
        menu += "\n0. Quit program";
        menu += "\nPlease select your option (1 to 7 or 0 to exit) >> ";

        boolean doContinue = true;

        while (doContinue) {
            System.out.print(menu);
            char option = scanner.next().charAt(0);
            scanner.nextLine();

            System.out.println("\n--------------");

            switch (option) {
                case '1' -> addShape();
                case '2' -> removeShape();
                case '3' -> getShapeInfo();
                case '4' -> calculateAreaPerimeter();
                case '5' -> displayAllShapes();
                case '6' -> translateShapes();
                case '7' -> scaleShapes();
                case '0' -> {
                    System.out.println("Thank you for using the program!");
                    doContinue = false;
                }
                default -> System.out.println("Invalid option! Please provide a valid option.");
            }

            if (option != '0') {
                doContinue = wannaContinue();
            }
        }
    }

    // Adds a new shape to the shape list
    private void addShape() {
        System.out.print("Please choose shape:\nC for Circle\nR for Rectangle\nS for Square\nT for Triangle\n>> ");
        char shapeChoice = scanner.next().toUpperCase().charAt(0);

        Shape newShape = null;

        switch (shapeChoice) {
            case 'C' -> {
                System.out.print("X-coordinate: ");
                int x = scanner.nextInt();
                System.out.print("Y-coordinate: ");
                int y = scanner.nextInt();
                System.out.print("Radius: ");
                double radius = scanner.nextDouble();

                Coordinates coord = new Coordinates(x, y);
                newShape = new Circle(coord, radius);
            }

            case 'R' -> {
                System.out.print("X-coordinate: ");
                int x = scanner.nextInt();
                System.out.print("Y-coordinate: ");
                int y = scanner.nextInt();
                System.out.print("Width: ");
                int width = scanner.nextInt();
                System.out.print("Length: ");
                int length = scanner.nextInt();

                Coordinates coord = new Coordinates(x, y);
                newShape = new Rectangle(coord, width, length);
            }

            case 'S' -> {
                System.out.print("X-coordinate: ");
                int x = scanner.nextInt();
                System.out.print("Y-coordinate: ");
                int y = scanner.nextInt();
                System.out.print("Side length: ");
                int side = scanner.nextInt();

                Coordinates coord = new Coordinates(x, y);
                newShape = new Square(coord, side);
            }

            case 'T' -> {
                System.out.print("Enter x1: ");
                int x1 = scanner.nextInt();
                System.out.print("Enter y1: ");
                int y1 = scanner.nextInt();
                System.out.print("Enter x2: ");
                int x2 = scanner.nextInt();
                System.out.print("Enter y2: ");
                int y2 = scanner.nextInt();
                System.out.print("Enter x3: ");
                int x3 = scanner.nextInt();
                System.out.print("Enter y3: ");
                int y3 = scanner.nextInt();

                Coordinates v1 = new Coordinates(x1, y1);
                Coordinates v2 = new Coordinates(x2, y2);
                Coordinates v3 = new Coordinates(x3, y3);

                newShape = new Triangle(v1, v2, v3);
            }

            default -> System.out.println("Invalid shape choice!");
        }

        if (newShape != null) {
            shapeList.addShape(newShape);
            System.out.println("Shape added successfully!");
        }
    }

    // Removes a shape from the list using its ID
    private void removeShape() {
        System.out.print("Please provide the ID of the shape: ");
        int id = scanner.nextInt();

        if (shapeList.isValid(id)) {
            shapeList.removeShape(id);
            System.out.println("Shape removed successfully!");
        } else {
            System.out.println("Invalid ID! Shape not found!");
        }
    }

    // Displays information about one shape using its ID
    private void getShapeInfo() {
        System.out.print("Please provide the ID of the shape: ");
        int id = scanner.nextInt();

        if (shapeList.isValid(id)) {
            System.out.println(shapeList.getShape(id).display());
        } else {
            System.out.println("Invalid ID! Shape not found!");
        }
    }

    // Calculates and displays the area and perimeter of a shape
    private void calculateAreaPerimeter() {
        System.out.print("Please provide the ID of the shape: ");
        int id = scanner.nextInt();

        if (shapeList.isValid(id)) {
            System.out.println("Area: " + String.format("%.2f", shapeList.area(id)));
            System.out.println("Perimeter: " + String.format("%.2f", shapeList.perimeter(id)));
        } else {
            System.out.println("Invalid ID! Shape not found!");
        }
    }

    // Displays all shapes in the list
    private void displayAllShapes() {
        System.out.println(shapeList.display());
    }

    // Translates all shapes by the given x and y values
    private void translateShapes() {
        System.out.print("Translate x value: ");
        int dx = scanner.nextInt();
        System.out.print("Translate y value: ");
        int dy = scanner.nextInt();

        shapeList.translateShapes(dx, dy);
        System.out.println("All shapes translated successfully!");
    }

    // Scales all shapes using the given factor and sign
    private void scaleShapes() {
        int factor;

        while (true) {
            System.out.print("Provide scaling factor: ");
            factor = scanner.nextInt();

            if (factor != 0) {
                break;
            }

            System.out.println("Factor zero is not acceptable!");
        }

        System.out.print("Provide scale sign (true for multiply / false for divide): ");
        boolean sign = scanner.nextBoolean();

        shapeList.scale(factor, sign);
        System.out.println("All shapes scaled successfully!");
    }
}
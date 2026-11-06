package app;

import elements.Circle;
import elements.Shape;
import elements.Square;
import elements.Triangle;
import visitors.AreaCalculatorVisitor;
import visitors.ExportVisitor;
import visitors.PerimeterCalculatorVisitor;
import visitors.ShapeVisitor;

import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        List<Shape> shapes = List.of(
                new Circle(5),
                new Square(4),
                new Triangle(3, 4, 5)
        );

        AreaCalculatorVisitor areaVisitor =
                new AreaCalculatorVisitor();

        ExportVisitor exportVisitor =
                new ExportVisitor();

        PerimeterCalculatorVisitor perimeterVisitor =
                new PerimeterCalculatorVisitor();

        applyVisitor(shapes, areaVisitor);
        applyVisitor(shapes, exportVisitor);
        applyVisitor(shapes, perimeterVisitor);

        System.out.println("=== Shape Export ===");
        System.out.print(exportVisitor.getOutput());

        System.out.println();
        System.out.println("=== Calculations ===");

        System.out.printf(
                Locale.US,
                "Total area: %.2f%n",
                areaVisitor.getTotalArea()
        );

        System.out.printf(
                Locale.US,
                "Total perimeter: %.2f%n",
                perimeterVisitor.getTotalPerimeter()
        );
    }

    private static void applyVisitor(
            List<Shape> shapes,
            ShapeVisitor visitor
    ) {
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}
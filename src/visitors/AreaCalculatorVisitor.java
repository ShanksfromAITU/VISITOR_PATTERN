package visitors;

import elements.Circle;
import elements.Square;
import elements.Triangle;

public final class AreaCalculatorVisitor implements ShapeVisitor {
    private double totalArea;

    @Override
    public void visitCircle(Circle circle) {
        double radius = circle.getRadius();
        totalArea += Math.PI * radius * radius;
    }

    @Override
    public void visitSquare(Square square) {
        double side = square.getSide();
        totalArea += side * side;
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        double a = triangle.getSideA();
        double b = triangle.getSideB();
        double c = triangle.getSideC();
        double semiPerimeter = (a + b + c) / 2.0;

        double area = Math.sqrt(
                semiPerimeter
                        * (semiPerimeter - a)
                        * (semiPerimeter - b)
                        * (semiPerimeter - c)
        );

        totalArea += area;
    }

    public double getTotalArea() {
        return totalArea;
    }
}
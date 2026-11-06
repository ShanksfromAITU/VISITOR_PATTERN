package visitors;

import elements.Circle;
import elements.Square;
import elements.Triangle;

public final class PerimeterCalculatorVisitor implements ShapeVisitor {
    private double totalPerimeter;

    @Override
    public void visitCircle(Circle circle) {
        totalPerimeter += 2 * Math.PI * circle.getRadius();
    }

    @Override
    public void visitSquare(Square square) {
        totalPerimeter += 4 * square.getSide();
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        totalPerimeter += triangle.getSideA()
                + triangle.getSideB()
                + triangle.getSideC();
    }

    public double getTotalPerimeter() {
        return totalPerimeter;
    }
}
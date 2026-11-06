package visitors;

import elements.Circle;
import elements.Square;
import elements.Triangle;

public interface ShapeVisitor {
    void visitCircle(Circle circle);
    void visitSquare(Square square);
    void visitTriangle(Triangle triangle);
}